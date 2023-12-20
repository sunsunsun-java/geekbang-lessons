package org.geekbang.mini.spring.beans.factory.config;

import org.geekbang.mini.spring.beans.BeansException;

public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
