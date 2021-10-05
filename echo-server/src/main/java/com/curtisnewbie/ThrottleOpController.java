package com.curtisnewbie;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yongjie.zhuang
 */
@RestController
@RequestMapping("/throttle")
public class ThrottleOpController {

    private static final Logger log = LoggerFactory.getLogger(ThrottleOpController.class);

    @RateLimiter(name = "throttledOp", fallbackMethod = "slowdownMsg")
    @GetMapping("/op")
    public String opShouldBeThrottled() {
        return "pong";
    }

    public String slowdownMsg(Exception e) {
//        log.warn("Resilience4j rate limiter triggered", e);
        return "Please slow down";
    }

}
