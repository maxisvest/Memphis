package com.github.maxisvest.controller;

import com.github.maxisvest.service.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Create by yuyang
 * 2021/4/2 11:11
 */
@Controller
@RequestMapping("/test")
public class DemoController {

    @Resource
    private DemoService demoService;

    @RequestMapping("testDemo")
    @ResponseBody
    public Object testDemo() {
        return demoService.test();
    }

}
