package com.turan.mq.bo;

import lombok.Data;

@Data
public class MqCommonAlarm
{
    private Long vehicleNo;
    private Integer type;
    private Integer status;
}
