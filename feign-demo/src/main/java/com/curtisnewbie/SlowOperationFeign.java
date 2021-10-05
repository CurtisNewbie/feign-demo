package com.curtisnewbie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yongjie.zhuang
 */
@FeignClient(name = "slowOperationFeign", url = "http://localhost:8080", path = "/operation",
        fallback = SlowOperationFeign.SlowOperationFeignFallback.class)
public interface SlowOperationFeign {

    @GetMapping("/slow")
    String slowOperation();

    @Component
    class SlowOperationFeignFallback implements SlowOperationFeign {

        @Override
        public String slowOperation() {
            return "slow operation not available, resilience4j triggered";
        }
    }
}
