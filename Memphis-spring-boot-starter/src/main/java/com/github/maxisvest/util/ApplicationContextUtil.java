package com.github.maxisvest.util;

import com.github.maxisvest.annotation.MemphisComponent;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;

/**
 * Create by yuyang
 * 2021/4/2 15:12
 */
@Component
public class ApplicationContextUtil {

    @Resource
    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    private static String EXTENDED_SERVICE_CLASS = "com.hqjl.scheduler.interf.OptimizeProxyComponentProvider";

    public void a() {
        try {
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{}, Thread.currentThread().getContextClassLoader());
            URL url = new URL("");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            Method addJarMethod = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addJarMethod.setAccessible(true);
            addJarMethod.invoke(urlClassLoader, url);
            Class<?> c = urlClassLoader.loadClass(EXTENDED_SERVICE_CLASS);

            this.onChange(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String onChange(Class definitionClass) {
        //获取BeanFactory
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ((ConfigurableApplicationContext)applicationContext).getBeanFactory();

        Map<String, Object> beansWithAnnotation = beanFactory.getBeansWithAnnotation(MemphisComponent.class);

        MemphisComponent annotation = (MemphisComponent) definitionClass.getAnnotation(MemphisComponent.class);
        String beanName = annotation.beanName();

        try {

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(definitionClass.getClass());
            Object targetBean = enhancer.create();

            // 消除原先的bean
            beanFactory.removeBeanDefinition(beanName);

            GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
            genericBeanDefinition.setBeanClass(definitionClass);
            // genericBeanDefinition.setBeanClassName(targetBean.getClass().getCanonicalName());
            beanFactory.registerBeanDefinition(beanName, genericBeanDefinition);
            beanFactory.registerSingleton(beanName, targetBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "register Bean Success";
    }

    public Object getBean(Class<?> requiredType) {
        return applicationContext.getBean(requiredType);
    }

}
