package com.turan.handler;

import com.turan.mq.bo.MqGpsInfo;

public interface ActiveAlarmHandler
{
    void handle(MqGpsInfo msg);
}
