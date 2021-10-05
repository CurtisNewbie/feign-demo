package com.curtisnewbie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yongjie.zhuang
 */
@FeignClient(name = "throttledOpFeign", path = "/throttle", url = "http://localhost:8080")
public interface ThrottleOpFeign {

    @GetMapping("/op")
    String getResp();
}
