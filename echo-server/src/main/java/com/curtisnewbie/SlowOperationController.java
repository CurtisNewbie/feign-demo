package com.curtisnewbie;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yongjie.zhuang
 */
@RestController
@RequestMapping("/operation")
public class SlowOperationController {

    @GetMapping("/slow")
    public String slowOperation() throws InterruptedException {
        // this should trigger timeout
        Thread.sleep(5 * 1000);
        return "Slow operation finished, you should not see this message";
    }
}
