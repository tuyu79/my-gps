package com.turan.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.turan.dao.CommonAlarmDAO;
import com.turan.dao.GpsInfoDAO;
import com.turan.example.protocol.message.activesafe.A_0x64;
import com.turan.example.protocol.message.activesafe.A_0x66;
import com.turan.example.protocol.message.activesafe.AlarmMarkUid;
import com.turan.example.protocol.message.activesafe.GpsBase;
import com.turan.example.protocol.message.dev.D_0200;
import com.turan.mq.bo.MQ808Msg;
import com.turan.po.GpsInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MqGpsInfoServiceTest
{
    @InjectMocks
    private MqGpsInfoService mqGpsInfoService;
    @Mock
    private GpsInfoDAO gpsInfoDAO;
    @Mock
    private CommonAlarmDAO commonAlarmDAO;
    @Mock
    private GlobalSequenceService globalSequenceService;
    @Mock
    private MessageChannel output;

    private GpsBase gpsBase;
    private MQ808Msg mq808Msg;
    private D_0200 d_0200;
    private A_0x64 a_0x64;
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

        d_0200 = new D_0200();

        mq808Msg = new MQ808Msg();
        mq808Msg.setVehicleNo(1L);

        a_0x64 = new A_0x64();
        a_0x64.setId(1);
        a_0x64.setStatus(1);
        a_0x64.setEventType(1);
        a_0x64.setLevel(1);
        a_0x64.setForwardSpeed(10);
        a_0x64.setDistance(100);
        a_0x64.setDeviationType(0);
        a_0x64.setRoadMarkType(1);
        a_0x64.setRoadMarkRecData(1);
        a_0x64.setSpeed(10);
        a_0x64.setHeight(1000);
        a_0x64.setLatitude((int) (23.5 * Math.pow(10, 6)));
        a_0x64.setLongitude((int) (23.5 * Math.pow(10, 6)));
        a_0x64.setDate(new Date());
        a_0x64.setVehicleStatus(1);

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
    public void whenCommonAlarmThenSuccess()
    {
        gpsBase.setAlarm(1);
        d_0200.setBase(gpsBase);
        mq808Msg.setMsgType("GPS");
        mq808Msg.setMsgBody(JSON.toJSONString(d_0200));

        mqGpsInfoService.handle(mq808Msg);

        verify(gpsInfoDAO, times(1)).insert(any(GpsInfo.class));
        verify(commonAlarmDAO, times(1)).insertList(any(List.class));
        verify(output, times(1)).send(any(Message.class));
    }

    @Test
    public void whenCommonAlarmStartAndEndThenSuccess()
    {

        // 开始报警
        gpsBase.setAlarm(1);
        d_0200.setBase(gpsBase);
        mq808Msg.setMsgType("GPS");
        mq808Msg.setMsgBody(JSON.toJSONString(d_0200));

        mqGpsInfoService.handle(mq808Msg);

        // 结束报警
        gpsBase.setAlarm(0);
        d_0200.setBase(gpsBase);
        mq808Msg.setMsgType("GPS");
        mq808Msg.setMsgBody(JSON.toJSONString(d_0200));

        mqGpsInfoService.handle(mq808Msg);

        verify(gpsInfoDAO, times(2)).insert(any(GpsInfo.class));
        verify(commonAlarmDAO, times(1)).insertList(any(List.class));
        verify(output, times(2)).send(any(Message.class));
    }

}