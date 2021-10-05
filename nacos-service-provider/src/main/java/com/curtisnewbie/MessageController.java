package com.curtisnewbie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author yongjie.zhuang
 */
@RestController
@RequestMapping("/messages")
public class MessageController {

    @GetMapping("/latest")
    public String getLatestMessage() {
        return "Now " + new Date().toString();
    }
}
