package org.geekbang.thinking.in.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * {@link Component} 扫描示例
 */
// basePackages() @AliasFor value()
// value() @AliasFor basePackages()
@MyComponentScan2(basePackages = "org.geekbang.thinking.in.spring.annotation")
//@ComponentScan(value = "org.geekbang.thinking.in.spring.annotation")
public class ComponentScanDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class
        context.register(ComponentScanDemo.class);

        // 启动 Spring 应用上下文
        context.refresh();

        // 依赖查找 TestClass Bean
        // TestClass 标注 @MyComponent2
        // @MyComponent2 <- @MyComponent <- @Component
        TestClass testClass = context.getBean(TestClass.class);
        System.out.println(testClass);

        // 关闭 Spring 应用上下文
        context.close();
    }

}
