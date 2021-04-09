package com.github.maxisvest.loader;

/**
 * Create by yuyang
 * 2021/4/1 18:36
 */
public interface DynamicLoader {


    <T> Class<T> loadClassImpl(Class<T> beanClass);

}