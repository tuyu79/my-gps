package com.turan.handler;

import com.google.common.collect.ImmutableMap;
import com.turan.common.RespCode;
import com.turan.common.ResultBean;
import com.turan.dao.ActiveAlarm0x64DAO;
import com.turan.enums.AlarmStatusEnum;
import com.turan.example.mq.CommonResponse;
import com.turan.example.protocol.message.activesafe.A_0x64;
import com.turan.feign.AttachmentApi;
import com.turan.feign.api.attachment.bo.TaskRequest;
import com.turan.mq.bo.MqActiveAlarm;
import com.turan.mq.bo.MqGpsInfo;
import com.turan.po.ActiveAlarm0x64;
import com.turan.service.GlobalSequenceService;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class A_0x64Handler implements ActiveAlarmHandler
{

    private static final String UNDER_LINE = "_";
    // 有则表示报警开始,无则表示没有主动安全报警
    private Map<String/* vehicleNo + type*/, A_0x64/* 标志位*/> lastActiveAlarmTable = new ConcurrentHashMap<>();

    @Autowired
    private ActiveAlarm0x64DAO activeAlarm0x64DAO;
    @Autowired
    private GlobalSequenceService globalSequenceService;
    @Autowired
    private MessageChannel output;
    @Autowired
    private AttachmentApi attachmentApi;

    @Override
    public void handle(MqGpsInfo msg)
    {
        if (msg.getA_0x64() != null)
        {
            // 处理主动安全报警
            A_0x64 a_0x64 = msg.getA_0x64();
            ActiveAlarm0x64 activeAlarm0x64 = new ActiveAlarm0x64();
            activeAlarm0x64.setAlarmNo(globalSequenceService.nextId());
            activeAlarm0x64.setVehicleNo(msg.getVehicleNo());
            activeAlarm0x64.setAlarmId(a_0x64.getId());
            activeAlarm0x64.setMarkStatus(a_0x64.getStatus());
            activeAlarm0x64.setAlarmType(a_0x64.getEventType());
            activeAlarm0x64.setAlarmLevel(a_0x64.getLevel());
            activeAlarm0x64.setDeviationType(a_0x64.getDeviationType());
            activeAlarm0x64.setRoadMarkType(a_0x64.getRoadMarkType());
            activeAlarm0x64.setRoadMarkData(a_0x64.getRoadMarkRecData());
            activeAlarm0x64.setSpeed(a_0x64.getSpeed());
            activeAlarm0x64.setHeight(a_0x64.getHeight());
            activeAlarm0x64.setLatitude(a_0x64.getLatitude());
            activeAlarm0x64.setLongitude(a_0x64.getLongitude());
            activeAlarm0x64.setTime(a_0x64.getDate());
            activeAlarm0x64.setStatusBit(a_0x64.getVehicleStatus());
            activeAlarm0x64.setDevId(a_0x64.getAlarmMarkUid().getDevId());
            activeAlarm0x64.setMarkTime(a_0x64.getAlarmMarkUid().getDate());
            activeAlarm0x64.setMarkSequence(a_0x64.getAlarmMarkUid().getSequence());
            activeAlarm0x64.setAttachmentNum(a_0x64.getAlarmMarkUid().getFileNum());
            activeAlarm0x64.setReserve(a_0x64.getAlarmMarkUid().getReserve());

            activeAlarm0x64DAO.insert(activeAlarm0x64);

            MqActiveAlarm mqActiveAlarm = new MqActiveAlarm();
            mqActiveAlarm.setVehicleNo(msg.getVehicleNo());
            mqActiveAlarm.setActiveType(A_0x64.EXTRA_ID);
            mqActiveAlarm.setEventType(a_0x64.getEventType());
            mqActiveAlarm.setStatus(AlarmStatusEnum.START.getCode());

            output.send(MessageBuilder.createMessage(
                    mqActiveAlarm, new MessageHeaders(ImmutableMap.of())
            ));

            lastActiveAlarmTable.put(buildKey(msg.getVehicleNo()), a_0x64);

            // 添加任务
            TaskRequest taskRequest = new TaskRequest();
            taskRequest.setVehicleNo(msg.getVehicleNo());
            taskRequest.setPlatformAlarmUid(activeAlarm0x64.getAlarmNo());
            taskRequest.setFileCount(activeAlarm0x64.getAttachmentNum());
            taskRequest.setAlarmMarkUid(a_0x64.getAlarmMarkUid());

            log.info("add task,taskRequest: [{}]", taskRequest);

            ResultBean<Void> result = attachmentApi.addTask(taskRequest);
            if (RespCode.SUCCESS.getCode() != result.getCode())
            {
                log.error("[dubbo invoke fail],provider: attachment,result: [{}]", result.getCode());
            } else
            {
                log.info("[dubbo invoke success],provider: attachment");
            }

        } else if (lastActiveAlarmTable.containsKey(buildKey(msg.getVehicleNo())))
        {
            A_0x64 a_0x64 = lastActiveAlarmTable.get(buildKey(msg.getVehicleNo()));

            // 清除0x64报警
            MqActiveAlarm mqActiveAlarm = new MqActiveAlarm();
            mqActiveAlarm.setVehicleNo(msg.getVehicleNo());
            mqActiveAlarm.setActiveType(A_0x64.EXTRA_ID);
            mqActiveAlarm.setEventType(a_0x64.getEventType());
            mqActiveAlarm.setStatus(AlarmStatusEnum.END.getCode());

            output.send(MessageBuilder.createMessage(
                    mqActiveAlarm, new MessageHeaders(ImmutableMap.of())
            ));
            lastActiveAlarmTable.remove(buildKey(msg.getVehicleNo()));
        }
    }

    private String buildKey(Long vehicleNo)
    {
        return vehicleNo + UNDER_LINE + A_0x64.EXTRA_ID;
    }
}
