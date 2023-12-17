package org.geekbang.mini.spring.context;

import org.geekbang.mini.spring.beans.BeanFactory;
import org.geekbang.mini.spring.beans.NoSuchBeanDefinitionException;
import org.geekbang.mini.spring.beans.SimpleBeanFactory;
import org.geekbang.mini.spring.beans.BeanDefinition;
import org.geekbang.mini.spring.beans.XmlBeanDefinitionReader;
import org.geekbang.mini.spring.core.ClassPathXmlResource;
import org.geekbang.mini.spring.core.Resource;

public class ClassPathXmlApplicationContext implements BeanFactory {
    private BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        Resource classPathXmlResource = new ClassPathXmlResource(fileName);
        BeanFactory simpleBeanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(simpleBeanFactory);
        reader.loadBeanDefinitions(classPathXmlResource);
        this.beanFactory = simpleBeanFactory;
    }

    @Override
    public Object getBean(String beanName) throws NoSuchBeanDefinitionException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }
}
