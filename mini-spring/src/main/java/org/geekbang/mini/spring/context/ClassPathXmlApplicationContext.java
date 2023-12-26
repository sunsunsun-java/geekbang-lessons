package org.geekbang.mini.spring.context;

import org.geekbang.mini.spring.beans.BeansException;
import org.geekbang.mini.spring.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.geekbang.mini.spring.beans.factory.config.BeanFactoryPostProcessor;
import org.geekbang.mini.spring.beans.factory.config.ConfigurableListableBeanFactory;
import org.geekbang.mini.spring.beans.factory.support.DefaultListableBeanFactory;
import org.geekbang.mini.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.geekbang.mini.spring.core.ClassPathXmlResource;
import org.geekbang.mini.spring.core.Resource;

import java.util.ArrayList;
import java.util.List;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    private final DefaultListableBeanFactory beanFactory;
    private final List<BeanFactoryPostProcessor> beanFactoryPostProcessors = new ArrayList<>();

    public ClassPathXmlApplicationContext(String fileName) {
        this(fileName, true);
    }

    public ClassPathXmlApplicationContext(String fileName, boolean isRefresh) {
        Resource classPathXmlResource = new ClassPathXmlResource(fileName);
        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(classPathXmlResource);
        this.beanFactory = bf;

        if (isRefresh) {
            try {
                refresh();
            } catch (BeansException | IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void registerListeners() {
        ApplicationListener listener = new ApplicationListener();
        this.getApplicationEventPublisher().addApplicationListener(listener);
    }

    @Override
    public void initApplicationEventPublisher() {
        ApplicationEventPublisher aep = new SimpleApplicationEventPublisher();
        this.setApplicationEventPublisher(aep);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) {

    }

    @Override
    public void registerBeanPostProcessors(ConfigurableListableBeanFactory bf) {
        this.beanFactory.addBeanPostProcessor(new AutowiredAnnotationBeanPostProcessor());
    }

    @Override
    public void onRefresh() {
        this.beanFactory.refresh();
    }

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
        return this.beanFactory;
    }

    @Override
    public void addApplicationListener(ApplicationListener listener) {
        this.getApplicationEventPublisher().addApplicationListener(listener);
    }

    @Override
    public void finishRefresh() {
        publishEvent(new ContextRefreshEvent("Context Refreshed..."));
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        this.getApplicationEventPublisher().publishEvent(event);
    }
}
