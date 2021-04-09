package com.github.maxisvest.annotation;

import org.springframework.stereotype.Component;

/**
 * Create by yuyang
 * 2021/4/2 15:33
 */
@Component
public @interface MemphisComponent {

    String beanName();

    String classPackage();

}
