package org.geekbang.mini.spring.beans;

public interface BeanFactory {
    Object getBean(String beanName) throws NoSuchBeanDefinitionException;

    void registerBeanDefinition(BeanDefinition beanDefinition);
}
