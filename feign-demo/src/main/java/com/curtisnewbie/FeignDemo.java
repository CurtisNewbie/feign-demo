package com.curtisnewbie;

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author yongjie.zhuang
 */
@Component
public class FeignDemo {

    private static final Logger logger = LoggerFactory.getLogger(FeignDemo.class);

    @Autowired
    private EchoServerFeign echoServerFeign;

    @Autowired
    private SlowOperationFeign slowOperationFeign;

    @Autowired
    private ThrottleOpFeign throttleOpFeign;

    private final AtomicBoolean isShutdown = new AtomicBoolean(false);

    @PreDestroy
    private void preDestroy() {
        isShutdown.set(true);
    }

    @PostConstruct
    private void init() {
        new Thread(() -> {
            for (; ; ) {
                if (isShutdown.get())
                    return;

                try {
                    logger.info("Called EchoServer, response: {}", echoServerFeign.getEchoMsg());
                    logger.info("Get echo count from EchoServer, response: {}", echoServerFeign.getEchoCount());
                    logger.info("Get dummy from EchoServer, response: {}", echoServerFeign.getDummy());
                    logger.info("Slow operation, response: {}", slowOperationFeign.slowOperation());
                    Thread.sleep(500);
                } catch (Exception e) {
                    if (e instanceof InterruptedException)
                        Thread.currentThread().interrupt();
                    logger.error("Error", e);
                }
            }

        }).start();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (; ; ) {
                    if (isShutdown.get())
                        return;

                    try {
                        logger.info("ThrottleOpFeign, resp: {}", throttleOpFeign.getResp());
                        Thread.sleep(100);
                    } catch (Exception e) {
                        if (e instanceof InterruptedException)
                            Thread.currentThread().interrupt();
                        logger.error("Error", e);
                    }
                }
            }).start();
        }
    }

}
