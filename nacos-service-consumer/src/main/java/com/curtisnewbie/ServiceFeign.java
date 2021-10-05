package com.curtisnewbie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yongjie.zhuang
 */
@FeignClient(name = "nacos-service-provider", fallback = ServiceFeign.ServiceFeignFallback.class)
public interface ServiceFeign {

    @GetMapping("/messages/latest")
    String getMessage();

    @Component
    class ServiceFeignFallback implements ServiceFeign {

        @Override
        public String getMessage() {
            return "fallback";
        }
    }
}
