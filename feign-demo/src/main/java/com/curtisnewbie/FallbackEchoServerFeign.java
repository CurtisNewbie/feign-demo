package com.curtisnewbie;

import org.springframework.stereotype.Component;

/**
 * @author yongjie.zhuang
 */
@Component
public class FallbackEchoServerFeign implements EchoServerFeign {

    @Override
    public String getEchoMsg() {
        return "Server not available";
    }

    @Override
    public int getEchoCount() {
        return -1;
    }

    @Override
    public FDummy getDummy() {
        return null;
    }
}
