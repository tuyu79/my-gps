package com.turan.mq.bo;

import com.turan.example.protocol.message.activesafe.A_0x64;
import com.turan.example.protocol.message.activesafe.A_0x66;
import com.turan.example.protocol.message.activesafe.GpsBase;
import com.turan.example.protocol.message.dev.D_0200;
import lombok.Data;

@Data
public class MqGpsInfo extends D_0200
{
    private Long vehicleNo;
}
