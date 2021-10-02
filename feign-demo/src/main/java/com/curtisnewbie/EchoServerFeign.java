package com.curtisnewbie;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * Feign client for echo-server
 * </p>
 *
 * @author yongjie.zhuang
 */
@FeignClient(name = "echoServerFeign", url = "http://localhost:8080", fallback = FallbackEchoServerFeign.class,
        configuration = EchoServerFeignConfig.class)
public interface EchoServerFeign {

    @GetMapping(value = "/echo/msg")
    String getEchoMsg();

    @GetMapping(value = "/echo/count")
    int getEchoCount();

    @GetMapping(value = "/echo/dummy")
    FDummy getDummy();

}
