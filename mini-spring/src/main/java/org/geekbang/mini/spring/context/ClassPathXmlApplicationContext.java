package org.geekbang.mini.spring.context;

import org.geekbang.mini.spring.beans.*;
import org.geekbang.mini.spring.beans.factory.BeanFactory;
import org.geekbang.mini.spring.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.geekbang.mini.spring.beans.factory.config.AutowireCapableBeanFactory;
import org.geekbang.mini.spring.beans.factory.config.BeanFactoryPostProcessor;
import org.geekbang.mini.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.geekbang.mini.spring.core.ClassPathXmlResource;
import org.geekbang.mini.spring.core.Resource;

import java.util.ArrayList;
import java.util.List;

public class ClassPathXmlApplicationContext implements BeanFactory, ApplicationEventPublisher {
    private final AutowireCapableBeanFactory beanFactory;
    private final List<BeanFactoryPostProcessor> beanFactoryPostProcessors = new ArrayList<>();

    public ClassPathXmlApplicationContext(String fileName) {
        this(fileName, true);
    }

    public ClassPathXmlApplicationContext(String fileName, boolean isRefresh) {
        Resource classPathXmlResource = new ClassPathXmlResource(fileName);
        AutowireCapableBeanFactory bf = new AutowireCapableBeanFactory();
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

    public void registerBean(String beanName, Object obj) {
        this.beanFactory.registerBean(beanName, obj);
    }

    public List<BeanFactoryPostProcessor> getBeanFactoryPostProcessors() {
        return this.beanFactoryPostProcessors;
    }

    public void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor) {
        this.beanFactoryPostProcessors.add(postProcessor);
    }

    public void refresh() throws BeansException, IllegalStateException {
        registerBeanPostProcessors(this.beanFactory);
        onRefresh();
    }

    private void registerBeanPostProcessors(AutowireCapableBeanFactory bf) {
        bf.addBeanPostProcessor(new AutowiredAnnotationBeanPostProcessor());
    }

    private void onRefresh() {
        this.beanFactory.refresh();
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public boolean containsBean(String name) {
        return this.beanFactory.containsBean(name);
    }

    @Override
    public boolean isSingleton(String name) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isPrototype(String name) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Class<?> getType(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void publishEvent(ApplicationEvent event) {

    }
}
