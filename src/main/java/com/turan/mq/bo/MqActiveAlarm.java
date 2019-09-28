package com.turan.mq.bo;

import lombok.Data;

@Data
public class MqActiveAlarm
{
    private Long vehicleNo;
    private Integer activeType;
    private Integer eventType;
    private Integer status;
}
