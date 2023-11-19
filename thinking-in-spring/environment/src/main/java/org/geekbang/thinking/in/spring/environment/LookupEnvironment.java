package org.geekbang.thinking.in.spring.environment;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import static org.springframework.context.ConfigurableApplicationContext.ENVIRONMENT_BEAN_NAME;

public class LookupEnvironment implements EnvironmentAware {
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(LookupEnvironment.class);
        context.refresh();

        LookupEnvironment bean = context.getBean(LookupEnvironment.class);

        // 通过 Environment Bean 名称 - 依赖查找
        Environment environment = context.getBean(ENVIRONMENT_BEAN_NAME, Environment.class);
        System.out.println(bean.environment);
        System.out.println(bean.environment == environment);

        context.close();
    }
}
