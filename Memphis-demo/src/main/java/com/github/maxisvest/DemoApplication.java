package com.github.maxisvest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Create by yuyang
 * 2021/4/2 11:12
 */
@SpringBootApplication(scanBasePackages = "com.github.maxisvest")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
