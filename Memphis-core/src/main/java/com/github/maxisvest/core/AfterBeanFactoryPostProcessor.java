package com.github.maxisvest.core;

import com.github.maxisvest.annotation.MemphisComponent;
import com.github.maxisvest.loader.DynamicLoader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Create by yuyang
 * 2021/4/2 18:05
 */
@Component
public class AfterBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Resource
    private DynamicLoader dynamicLoader;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Object> beansWithAnnotation = beanFactory.getBeansWithAnnotation(MemphisComponent.class);

        beansWithAnnotation.forEach((beanName, bean) -> {
            Class<?> classInterface = bean.getClass().getDeclaredClasses()[0];
            Class<?> classImpl = dynamicLoader.loadClassImpl(classInterface);


        });


    }

}
