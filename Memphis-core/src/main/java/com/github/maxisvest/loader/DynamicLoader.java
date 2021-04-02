package com.github.maxisvest.loader;

/**
 * Create by yuyang
 * 2021/4/1 18:36
 */
public interface DynamicLoader {


    <T> T load(Class<T> beanClass);

}