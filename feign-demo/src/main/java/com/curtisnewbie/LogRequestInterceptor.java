package com.curtisnewbie;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Interceptor that log request information
 * </p>
 *
 * @author yongjie.zhuang
 */
public class LogRequestInterceptor implements RequestInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LogRequestInterceptor.class);

    @Override
    public void apply(RequestTemplate template) {
        log.info("Sending {} request to '{}'", template.method(), template.url());
    }
}
