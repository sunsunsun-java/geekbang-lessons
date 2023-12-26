package org.geekbang.mini.spring.context;

import org.geekbang.mini.spring.beans.BeansException;
import org.geekbang.mini.spring.beans.factory.ListableBeanFactory;
import org.geekbang.mini.spring.beans.factory.config.BeanFactoryPostProcessor;
import org.geekbang.mini.spring.beans.factory.config.ConfigurableBeanFactory;
import org.geekbang.mini.spring.beans.factory.config.ConfigurableListableBeanFactory;
import org.geekbang.mini.spring.core.env.EnvironmentCapable;
import org.geekbang.mini.spring.core.env.Environment;

public interface ApplicationContext extends EnvironmentCapable, ListableBeanFactory, ConfigurableBeanFactory, ApplicationEventPublisher {
    String getApplicationName();

    long getStartupDate();

    ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException;

    void setEnvironment(Environment environment);

    Environment getEnvironment();

    void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor);

    void refresh() throws BeansException, IllegalStateException;

    void close();

    boolean isActive();
}
