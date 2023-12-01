package org.geekbang.thinking.in.spring.aop.features;

import org.geekbang.thinking.in.spring.aop.overview.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于 XML 配置 Pointcut 示例
 */
public class AspectJSchemaBasedPointcutDemo {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("classpath:/META-INF/spring-aop-context.xml");
        
        context.refresh();
        
        EchoService bean = context.getBean("echoService", EchoService.class);
        
        System.out.println(bean.echo("Hello.World"));
        
        context.close();
    }
    
}
