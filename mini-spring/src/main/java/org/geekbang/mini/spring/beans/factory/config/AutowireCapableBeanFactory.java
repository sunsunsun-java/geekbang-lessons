package org.geekbang.mini.spring.beans.factory.config;

import org.geekbang.mini.spring.beans.BeansException;
import org.geekbang.mini.spring.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.geekbang.mini.spring.beans.factory.support.AbstractBeanFactory;

import java.util.ArrayList;
import java.util.List;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    private final List<AutowiredAnnotationBeanPostProcessor> beanPostProcessors = new ArrayList<AutowiredAnnotationBeanPostProcessor>();

    public void addBeanPostProcessor(AutowiredAnnotationBeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public int getBeanPostProcessorCount() {
        return this.beanPostProcessors.size();
    }

    public List<AutowiredAnnotationBeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (AutowiredAnnotationBeanPostProcessor beanProcessor : getBeanPostProcessors()) {
            beanProcessor.setBeanFactory(this);
            Object current = beanProcessor.postProcessBeforeInitialization(result, beanName);
            if (current == null) {
                return result;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanProcessor : getBeanPostProcessors()) {
            Object current = beanProcessor.postProcessAfterInitialization(result, beanName);
            if (current == null) {
                return result;
            }
            result = current;
        }
        return result;
    }
}
