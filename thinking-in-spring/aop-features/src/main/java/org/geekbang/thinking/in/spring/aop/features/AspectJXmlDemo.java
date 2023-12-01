package org.geekbang.thinking.in.spring.aop.features;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Aspect // 声明为 Aspect 切面
@Configuration // Configuration Class
public class AspectJXmlDemo {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-aop-context.xml");
        
//        AspectJXmlDemo bean = context.getBean(AspectJXmlDemo.class);
        
        context.close();
    }
    
}
