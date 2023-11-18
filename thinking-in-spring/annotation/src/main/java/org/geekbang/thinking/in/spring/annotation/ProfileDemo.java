package org.geekbang.thinking.in.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

/**
 * {@link Profile} 示例
 * @see Profile
 * @see Environment#getActiveProfiles()
 * @Since
 */
public class ProfileDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ProfileDemo.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        environment.setDefaultProfiles("odd");
        environment.setActiveProfiles("even");
        applicationContext.refresh();
        Integer number = applicationContext.getBean("number", Integer.class);
        System.out.println(number);
        applicationContext.close();
    }

    @Bean(name = "number")
    @Profile("odd")
    public Integer odd() {
        return 1;
    }

    @Bean(name = "number")
//    @Profile("even")
    @Conditional(EvenCondition.class)
    public Integer even() {
        return 2;
    }
}
