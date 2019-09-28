package com.turan;

import com.turan.mq.MyInput;
import com.turan.mq.MyOutput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({MyInput.class, MyOutput.class})
@EnableFeignClients
@SpringCloudApplication
public class MyGpsApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MyGpsApplication.class, args);
    }
}
