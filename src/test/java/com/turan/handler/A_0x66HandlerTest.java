package com.turan.handler;

import com.google.common.collect.Lists;
import com.turan.common.RespCode;
import com.turan.common.ResultBean;
import com.turan.dao.ActiveAlarm0x66DAO;
import com.turan.example.protocol.message.activesafe.A_0x66;
import com.turan.example.protocol.message.activesafe.AlarmMarkUid;
import com.turan.example.protocol.message.activesafe.GpsBase;
import com.turan.feign.AttachmentApi;
import com.turan.feign.api.attachment.bo.TaskRequest;
import com.turan.mq.bo.MqGpsInfo;
import com.turan.po.ActiveAlarm0x66;
import com.turan.po.GpsInfo;
import com.turan.service.GlobalSequenceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class A_0x66HandlerTest
{

    @InjectMocks
    private A_0x66Handler a_0x66Handler;
    @Mock
    private GlobalSequenceService globalSequenceService;
    @Mock
    private MessageChannel output;
    @Mock
    private ActiveAlarm0x66DAO activeAlarm0x66DAO;
    @Mock
    private AttachmentApi attachmentApi;

    private GpsBase gpsBase;
    private MqGpsInfo mqGpsInfo;
    private A_0x66 a_0x66;
    private AlarmMarkUid alarmMarkUid;

    @Before
    public void setUp() throws Exception
    {
        gpsBase = new GpsBase();
        gpsBase.setStatus(1);
        gpsBase.setLatitude((int) (31.2 * Math.pow(10, 6)));
        gpsBase.setLongitude((int) (31.2 * Math.pow(10, 6)));
        gpsBase.setHeight(100);
        gpsBase.setSpeed(5);
        gpsBase.setDirection(340);
        gpsBase.setDate(new Date());

        mqGpsInfo = new MqGpsInfo();
        mqGpsInfo.setVehicleNo(1L);

        a_0x66 = new A_0x66();
        a_0x66.setId(1);
        a_0x66.setStatus(1);
        a_0x66.setSpeed(10);
        a_0x66.setHeight(1000);
        a_0x66.setLatitude((int) (23.5 * Math.pow(10, 6)));
        a_0x66.setLongitude((int) (23.5 * Math.pow(10, 6)));
        a_0x66.setDate(new Date());
        a_0x66.setVehicleStatus(1);
        a_0x66.setAlarmEventCount(1);
        a_0x66.setAlarmEventList(Lists.newArrayList());


        alarmMarkUid = new AlarmMarkUid();
        alarmMarkUid.setDevId("a123456");
        alarmMarkUid.setDate(new Date());
        alarmMarkUid.setSequence(1);
        alarmMarkUid.setFileNum(1);
        alarmMarkUid.setReserve(0);

        doReturn(1L).when(globalSequenceService).nextId();
    }

    @Test
    public void when0x66AlarmThenSuccess()
    {
        doReturn(ResultBean.of(RespCode.SUCCESS)).when(attachmentApi).addTask(any(TaskRequest.class));

        gpsBase.setAlarm(0);
        mqGpsInfo.setBase(gpsBase);

        a_0x66.setAlarmMarkUid(alarmMarkUid);
        mqGpsInfo.setA_0x66(a_0x66);

        a_0x66Handler.handle(mqGpsInfo);

        verify(activeAlarm0x66DAO,times(1)).insert(any(ActiveAlarm0x66.class));
        verify(output, times(1)).send(any(Message.class));
        verify(attachmentApi, times(1)).addTask(any(TaskRequest.class));
    }

    @Test
    public void when0x66AlarmStartAndEndThenSuccess()
    {
        doReturn(ResultBean.of(RespCode.SUCCESS)).when(attachmentApi).addTask(any(TaskRequest.class));

        gpsBase.setAlarm(0);
        mqGpsInfo.setBase(gpsBase);

        a_0x66.setAlarmMarkUid(alarmMarkUid);

        mqGpsInfo.setA_0x66(a_0x66);

        a_0x66Handler.handle(mqGpsInfo);

        mqGpsInfo.setA_0x66(null);
        a_0x66Handler.handle(mqGpsInfo);

        verify(activeAlarm0x66DAO, times(1)).insert(any(ActiveAlarm0x66.class));
        verify(output, times(2)).send(any(Message.class));
        verify(attachmentApi, times(1)).addTask(any(TaskRequest.class));
    }
}