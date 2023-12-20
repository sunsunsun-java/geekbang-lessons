package org.geekbang.mini.spring.beans.factory.support;

import org.geekbang.mini.spring.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String name, BeanDefinition bd);

    void removeBeanDefinition(String name);

    BeanDefinition getBeanDefinition(String name);

    boolean containsBeanDefinition(String name);
}
