package org.geekbang.thinking.in.spring.aop.features;

import org.geekbang.thinking.in.spring.aop.features.aspect.AspectConfiguration;
import org.geekbang.thinking.in.spring.aop.features.aspect.AspectConfiguration2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // Configuration Class
@EnableAspectJAutoProxy // 激活 Aspect 注解自动代理
public class AspectJAnnotationPointcutDemo {
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AspectJAnnotationPointcutDemo.class, AspectConfiguration.class, AspectConfiguration2.class);
        context.refresh();
        
        AspectJAnnotationPointcutDemo bean = context.getBean(AspectJAnnotationPointcutDemo.class);
        
        bean.execute();
        context.close();
    }
    
    public void execute() {
        System.out.println("execute()...");
    }
}
