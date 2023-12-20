package org.geekbang.mini.spring.beans.factory.config;

import org.geekbang.mini.spring.beans.BeansException;
import org.geekbang.mini.spring.beans.factory.BeanFactory;

public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(BeanFactory beanFactory) throws BeansException;
}
