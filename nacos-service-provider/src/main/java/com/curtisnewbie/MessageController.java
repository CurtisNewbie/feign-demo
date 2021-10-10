package com.curtisnewbie;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author yongjie.zhuang
 */
@RefreshScope
@RestController
@RequestMapping("/messages")
public class MessageController {

    @Value("${config:no config}")
    private String config;

    @GetMapping("/latest")
    public String getLatestMessage() {
        return "Now " + new Date().toString();
    }

    // demo for config-center
    @GetMapping("/config")
    public String getConfig(){
        return config;
    }

}
