package org.geekbang.mini.spring.context;

import org.geekbang.mini.spring.beans.*;
import org.geekbang.mini.spring.core.ClassPathXmlResource;
import org.geekbang.mini.spring.core.Resource;

public class ClassPathXmlApplicationContext implements BeanFactory, ApplicationEventPublisher {
    private final SimpleBeanFactory beanFactory;;

    public ClassPathXmlApplicationContext(String fileName) {
        this(fileName, true);
    }

    public ClassPathXmlApplicationContext(String fileName, boolean isRefresh) {
        Resource classPathXmlResource = new ClassPathXmlResource(fileName);
        SimpleBeanFactory simpleBeanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(simpleBeanFactory);
        reader.loadBeanDefinitions(classPathXmlResource);
        this.beanFactory = simpleBeanFactory;

        if (!isRefresh) {
            this.beanFactory.refresh();
        }
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
