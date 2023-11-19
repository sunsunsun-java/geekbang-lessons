package org.geekbang.thinking.in.spring.environment;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.EventListener;

/**
 * 注入 {@link Environment} 示例
 */
public class InjectingEnvironmentDemo implements EnvironmentAware, ApplicationContextAware {

    private Environment environment1;

    @Autowired
    private Environment environment2;

    private ApplicationContext applicationContext1;

    @Autowired
    private ApplicationContext applicationContext2;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment1 = environment;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext1 = applicationContext;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectingEnvironmentDemo.class);
        context.refresh();

        InjectingEnvironmentDemo bean = context.getBean(InjectingEnvironmentDemo.class);

        System.out.println(bean.environment1);
        System.out.println(bean.environment1 == bean.environment2);
        System.out.println(bean.environment1 == context.getEnvironment());
        System.out.println(bean.environment1 == bean.applicationContext1.getEnvironment());
        System.out.println(bean.applicationContext1 == bean.applicationContext2);
        System.out.println(bean.applicationContext1 == context);

        context.close();
    }
}
