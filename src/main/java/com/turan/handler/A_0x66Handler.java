package com.turan.handler;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.turan.dao.ActiveAlarm0x64DAO;
import com.turan.dao.ActiveAlarm0x66DAO;
import com.turan.enums.AlarmStatusEnum;
import com.turan.example.protocol.message.activesafe.A_0x64;
import com.turan.example.protocol.message.activesafe.A_0x66;
import com.turan.feign.AttachmentApi;
import com.turan.feign.api.attachment.bo.TaskRequest;
import com.turan.mq.bo.MqActiveAlarm;
import com.turan.mq.bo.MqGpsInfo;
import com.turan.po.ActiveAlarm0x66;
import com.turan.service.GlobalSequenceService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class A_0x66Handler implements ActiveAlarmHandler
{
    private static final String UNDER_LINE = "_";
    // 有则表示报警开始,无则表示没有主动安全报警
    private Map<String/* vehicleNo + type*/, A_0x66/* 标志位*/> lastActiveAlarmTable = new ConcurrentHashMap<>();

    @Autowired
    private ActiveAlarm0x66DAO activeAlarm0x66DAO;
    @Autowired
    private GlobalSequenceService globalSequenceService;
    @Autowired
    private MessageChannel output;
    @Reference
    private AttachmentApi attachmentApi;

    @Override
    public void handle(MqGpsInfo msg)
    {
        handle0x66(msg);
    }

    private void handle0x66(MqGpsInfo mqGpsInfo)
    {
        if (mqGpsInfo.getA_0x66() != null)
        {
            A_0x66 a_0x66 = mqGpsInfo.getA_0x66();
            ActiveAlarm0x66 activeAlarm0x66 = new ActiveAlarm0x66();
            activeAlarm0x66.setAlarmNo(globalSequenceService.nextId());
            activeAlarm0x66.setVehicleNo(mqGpsInfo.getVehicleNo());
            activeAlarm0x66.setAlarmId(a_0x66.getId());
            activeAlarm0x66.setMarkStatus(a_0x66.getStatus());
            activeAlarm0x66.setSpeed(a_0x66.getSpeed());
            activeAlarm0x66.setHeight(a_0x66.getHeight());
            activeAlarm0x66.setLatitude(a_0x66.getLatitude());
            activeAlarm0x66.setLongitude(a_0x66.getLongitude());
            activeAlarm0x66.setTime(a_0x66.getDate());
            activeAlarm0x66.setStatusBit(a_0x66.getVehicleStatus());
            activeAlarm0x66.setDevId(a_0x66.getAlarmMarkUid().getDevId());
            activeAlarm0x66.setMarkTime(a_0x66.getAlarmMarkUid().getDate());
            activeAlarm0x66.setMarkSequence(a_0x66.getAlarmMarkUid().getSequence());
            activeAlarm0x66.setAttachmentNum(a_0x66.getAlarmMarkUid().getFileNum());
            activeAlarm0x66.setReserve(a_0x66.getAlarmMarkUid().getReserve());
            activeAlarm0x66.setEventNum(a_0x66.getAlarmEventCount());
            activeAlarm0x66.setEventList(JSON.toJSONString(a_0x66.getAlarmEventList()));

            activeAlarm0x66DAO.insert(activeAlarm0x66);

            MqActiveAlarm mqActiveAlarm = new MqActiveAlarm();
            mqActiveAlarm.setVehicleNo(mqGpsInfo.getVehicleNo());
            mqActiveAlarm.setActiveType(A_0x66.EXTRA_ID);
            mqActiveAlarm.setEventType(null);
            mqActiveAlarm.setStatus(AlarmStatusEnum.START.getCode());

            output.send(MessageBuilder.createMessage(
                    mqActiveAlarm, new MessageHeaders(ImmutableMap.of())
            ));

            lastActiveAlarmTable.put(buildKey(mqGpsInfo.getVehicleNo()), a_0x66);

            // 添加任务
            TaskRequest taskRequest = new TaskRequest();
            taskRequest.setVehicleNo(mqGpsInfo.getVehicleNo());
            taskRequest.setPlatformAlarmUid(activeAlarm0x66.getAlarmNo());
            taskRequest.setFileCount(activeAlarm0x66.getAttachmentNum());

            attachmentApi.addTask(taskRequest);

        } else if (lastActiveAlarmTable.containsKey(buildKey(mqGpsInfo.getVehicleNo())))
        {
            // 清除0x64报警
            MqActiveAlarm mqActiveAlarm = new MqActiveAlarm();
            mqActiveAlarm.setVehicleNo(mqGpsInfo.getVehicleNo());
            mqActiveAlarm.setActiveType(A_0x66.EXTRA_ID);
            mqActiveAlarm.setEventType(null);
            mqActiveAlarm.setStatus(AlarmStatusEnum.END.getCode());

            output.send(MessageBuilder.createMessage(
                    mqActiveAlarm, new MessageHeaders(ImmutableMap.of())
            ));
            // 清除0x64报警
            lastActiveAlarmTable.remove(buildKey(mqGpsInfo.getVehicleNo()));
        }
    }

    private String buildKey(Long vehicleNo)
    {
        return vehicleNo + UNDER_LINE + A_0x66.EXTRA_ID;
    }
}
