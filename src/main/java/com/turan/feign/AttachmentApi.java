package com.turan.feign;

import com.turan.common.RespCode;
import com.turan.common.ResultBean;
import com.turan.feign.api.attachment.AttachmentFeignApi;
import com.turan.feign.api.attachment.bo.TaskRequest;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(value = "my-attachment", fallbackFactory = AttachmentApiFallbackFactory.class)
public interface AttachmentApi extends AttachmentFeignApi
{
}

@Component
@Slf4j
class AttachmentApiFallbackFactory implements FallbackFactory<AttachmentApi>
{
    @Override
    public AttachmentApi create(Throwable cause)
    {
        return new AttachmentApi()
        {
            @Override
            public ResultBean<Void> addTask(TaskRequest taskRequest)
            {
                log.error("fallback; reason was: {}", cause.getMessage());
                return ResultBean.of(RespCode.SYS_ERROR);
            }
        };
    }
}
