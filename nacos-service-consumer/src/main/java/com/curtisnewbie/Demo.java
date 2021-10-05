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
public class Demo {

    private static final Logger log = LoggerFactory.getLogger(DemoThread.class);

    @Autowired
    private ServiceFeign feign;

    @PostConstruct
    public void init() {
        new Thread(new DemoThread()).start();
    }

    private class DemoThread implements Runnable {

        @Override
        public void run() {
            for (; ; ) {
                log.info("Resp: {}", feign.getMessage());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
