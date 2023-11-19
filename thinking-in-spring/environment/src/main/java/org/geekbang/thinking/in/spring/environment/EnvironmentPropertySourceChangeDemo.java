package org.geekbang.thinking.in.spring.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentPropertySourceChangeDemo {

    @Value("${user.name}") // 不具备动态更新能力
    private String userName;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnvironmentPropertySourceChangeDemo.class);

        // 在 Spring 应用上下文启动前，调整 Environment 中的 PropertySource
        ConfigurableEnvironment environment = context.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        // 动态地插入 PropertySource 到 PropertySources 中
        Map<String, Object> source = new HashMap<>();
        source.put("user.name", "sun-sun-sun");
        MapPropertySource propertySource = new MapPropertySource("first-property-source", source);
        propertySources.addFirst(propertySource);

        context.refresh();

//        source.put("user.name", "007");

        EnvironmentPropertySourceChangeDemo bean = context.getBean(EnvironmentPropertySourceChangeDemo.class);
        System.out.println(bean.userName);

        for (PropertySource ps : propertySources) {
            System.out.printf("PropertySource(name=%s) 'user.name' 属性：%s\n", ps.getName(), ps.getProperty("user.name"));
        }

        context.close();
    }

}
