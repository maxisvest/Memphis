package com.github.maxisvest.service;

import com.github.maxisvest.config.MemphisProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Create by yuyang
 * 2021/4/1 19:28
 */
public class DynamicLoaderService {

    @Resource
    private MemphisProperties memphisProperties;

    public String getProperties() {
        return memphisProperties.getTest();
    }

}
