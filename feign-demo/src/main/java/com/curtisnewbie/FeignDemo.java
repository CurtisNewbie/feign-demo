package com.curtisnewbie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author yongjie.zhuang
 */
@Component
public class FeignDemo {

    private static final Logger logger = LoggerFactory.getLogger(FeignDemo.class);

    @Autowired
    private EchoServerFeign feign;

    @PostConstruct
    private void init() {
        new Thread(() -> {
            for (; ; ) {
                try {
                    logger.info("Called EchoServer, response: {}", feign.getEchoMsg());
                    logger.info("Get echo count from EchoServer, response: {}", feign.getEchoCount());
                    logger.info("Get dummy from EchoServer, response: {}", feign.getDummy());
                    Thread.sleep(1000);
                } catch (Exception e) {
                    if (e instanceof InterruptedException)
                        Thread.currentThread().interrupt();
                    logger.error("Error", e);
                }
            }

        }).start();
    }

}
