package com.turan.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.turan.dao.CommonAlarmDAO;
import com.turan.dao.GpsInfoDAO;
import com.turan.enums.AlarmStatusEnum;
import com.turan.example.protocol.message.activesafe.GpsBase;
import com.turan.handler.ActiveAlarmHandler;
import com.turan.mq.bo.MQ808Msg;
import com.turan.mq.bo.MqCommonAlarm;
import com.turan.mq.bo.MqGpsInfo;
import com.turan.po.CommonAlarm;
import com.turan.po.GpsInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class MqGpsInfoService
{

    private static final String UNDER_LINE = "_";
    // 根据标志位判断是否有该类型报警
    private Map<Long/* vehicleNo*/, Integer/* alarmMark*/> lastCommonAlarmTable = new ConcurrentHashMap<>();

    @Autowired
    private GpsInfoDAO gpsInfoDAO;
    @Autowired
    private CommonAlarmDAO commonAlarmDAO;
    @Autowired
    private GlobalSequenceService globalSequenceService;
    @Autowired
    private MessageChannel output;
    @Autowired
    private List<ActiveAlarmHandler> activeAlarmHandlers = Lists.newArrayList();

    public void handle(MQ808Msg mq808Msg)
    {

        log.info("received mq 808 msg,[{}]",mq808Msg);

        if(!mq808Msg.getMsgType().equals("GPS"))
        {
            return;
        }

        MqGpsInfo mqGpsInfo = JSON.parseObject(mq808Msg.getMsgBody(),MqGpsInfo.class);
        mqGpsInfo.setVehicleNo(mq808Msg.getVehicleNo());

        GpsBase gpsBase = mqGpsInfo.getBase();

        // 先储存GPS基本信息
        GpsInfo gpsInfo = new GpsInfo();
        gpsInfo.setGpsNo(globalSequenceService.nextId());
        gpsInfo.setVehicleNo(mqGpsInfo.getVehicleNo());
        gpsInfo.setAlarmMark(gpsBase.getAlarm());
        gpsInfo.setStatusBit(gpsBase.getStatus());
        gpsInfo.setLatitude(gpsBase.getLatitude());
        gpsInfo.setLongitude(gpsBase.getLongitude());
        gpsInfo.setHeight(gpsBase.getHeight());
        gpsInfo.setSpeed(gpsBase.getSpeed());
        gpsInfo.setDirection(gpsBase.getDirection());
        gpsInfo.setTime(gpsBase.getDate());

        gpsInfoDAO.insert(gpsInfo);

        handleCommonAlarm(mqGpsInfo);

        activeAlarmHandlers.forEach(handler -> {
            handler.handle(mqGpsInfo);
        });
    }


    private void handleCommonAlarm(MqGpsInfo mqGpsInfo)
    {
        // 处理基础报警
        Integer lastAlarmMark = lastCommonAlarmTable.get(mqGpsInfo.getVehicleNo());
        GpsBase gpsBase = mqGpsInfo.getBase();
        int curAlarmMark = gpsBase.getAlarm();

        List<CommonAlarm> commonAlarmList = Lists.newArrayList();
        List<CommonAlarm> cancelCommonAlarmList = Lists.newArrayList();

        for (int i = 0; i < 32; i++) // 报警标志位32位,遍历每一位判断是否报警
        {
            if ((curAlarmMark & (1 << i)) == 1)
            {
                CommonAlarm commonAlarm = new CommonAlarm();
                commonAlarm.setAlarmNo(globalSequenceService.nextId());
                commonAlarm.setVehicleNo(mqGpsInfo.getVehicleNo());
                commonAlarm.setAlarmType(1 << i);
                commonAlarm.setStatusBit(gpsBase.getStatus());
                commonAlarm.setTime(gpsBase.getDate());

                commonAlarmList.add(commonAlarm);
            } else if (lastAlarmMark != null && (lastAlarmMark & (1 << i)) == 1)
            {
                CommonAlarm cancelCommonAlarm = new CommonAlarm();
                cancelCommonAlarm.setVehicleNo(mqGpsInfo.getVehicleNo());
                cancelCommonAlarm.setAlarmType(1 << i);
                cancelCommonAlarm.setStatusBit(gpsBase.getStatus());
                cancelCommonAlarm.setTime(gpsBase.getDate());

                cancelCommonAlarmList.add(cancelCommonAlarm);
            }
        }

        // 更新GPS基础报警的标志位
        lastCommonAlarmTable.put(mqGpsInfo.getVehicleNo(), gpsBase.getAlarm());

        if (commonAlarmList.size() != 0)
        {
            commonAlarmDAO.insertList(commonAlarmList);
        }

        notifyCommonAlarm(commonAlarmList, cancelCommonAlarmList);
    }

    private void notifyCommonAlarm(List<CommonAlarm> commonAlarmList, List<CommonAlarm> cancelCommonAlarmList)
    {
        List<MqCommonAlarm> mqCommonAlarmList = Lists.newArrayList();

        commonAlarmList.forEach(commonAlarm ->
        {
            MqCommonAlarm alarm = new MqCommonAlarm();
            alarm.setVehicleNo(commonAlarm.getVehicleNo());
            alarm.setType(commonAlarm.getAlarmType());
            alarm.setStatus(AlarmStatusEnum.START.getCode());
            mqCommonAlarmList.add(alarm);
        });

        cancelCommonAlarmList.forEach(cancelCommonAlarm ->
        {
            MqCommonAlarm alarm = new MqCommonAlarm();
            alarm.setVehicleNo(cancelCommonAlarm.getVehicleNo());
            alarm.setType(cancelCommonAlarm.getAlarmType());
            alarm.setStatus(AlarmStatusEnum.END.getCode());
            mqCommonAlarmList.add(alarm);
        });

        mqCommonAlarmList.forEach(mqCommonAlarm ->
        {
            Message<MqCommonAlarm> message = MessageBuilder.createMessage(mqCommonAlarm, new MessageHeaders(ImmutableMap.of()));
            output.send(message);
        });
    }
}
