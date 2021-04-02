package com.github.maxisvest.config;

import com.github.maxisvest.service.DynamicLoaderService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by yuyang
 * 2021/4/1 19:20
 */
@Configuration
@ConditionalOnClass(DynamicLoaderService.class)
@EnableConfigurationProperties(MemphisProperties.class)
public class MemphisConfig {

    @Bean
    public DynamicLoaderService dynamicLoaderService() {
        return new DynamicLoaderService();
    }


}
