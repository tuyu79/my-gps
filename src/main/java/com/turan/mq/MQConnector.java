package com.turan.mq;

import com.turan.mq.bo.MQ808Msg;
import com.turan.service.MqGpsInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MQConnector
{
    @Autowired
    private MqGpsInfoService mqGpsInfoService;

    @StreamListener("input")
    public void input1(MQ808Msg mq808Msg)
    {
        handleWithCatchException(() -> mqGpsInfoService.handle(mq808Msg));
    }

    public <T> void handleWithCatchException(Callback callback)
    {
        try
        {
            callback.handle();
        }catch (Exception e)
        {
            log.error("[consume error]: ",e);
        }
    }

    interface Callback{
        void handle();
    }
}
