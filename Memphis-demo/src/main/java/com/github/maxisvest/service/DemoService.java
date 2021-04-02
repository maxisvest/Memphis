package com.github.maxisvest.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Create by yuyang
 * 2021/4/2 11:12
 */
@Service
public class DemoService {


    @Resource
    private DynamicLoaderService dynamicLoaderService;

    public String test() {
        return dynamicLoaderService.getProperties();
    }


}
