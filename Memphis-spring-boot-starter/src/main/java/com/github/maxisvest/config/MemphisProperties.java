package com.github.maxisvest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Create by yuyang
 * 2021/4/2 10:58
 */
@ConfigurationProperties(prefix = "memphis")
public class MemphisProperties {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
