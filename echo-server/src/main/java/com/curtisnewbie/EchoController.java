package com.curtisnewbie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yongjie.zhuang
 */
@RestController
@RequestMapping("/echo")
public class EchoController {

    private static final Logger logger = LoggerFactory.getLogger(EchoController.class);
    private static final AtomicInteger atoInt = new AtomicInteger(0);
    private static final SecureRandom sr = new SecureRandom("abcde".getBytes());

    @GetMapping("/msg")
    public String echoMsg() {
        logger.info("Received echo, echo back");
        atoInt.incrementAndGet();
        return "echo";
    }

    @GetMapping("/count")
    public int count() {
        logger.info("Received echo count request, return count");
        return atoInt.get();
    }

    @GetMapping("/dummy")
    public Dummy dummy(){
        logger.info("Received dummy request, return dummy");
        Dummy d = new Dummy();
        d.setDescription("I am dummy bean");
        d.setNumber(sr.nextInt(100));
        return d;
    }

}
