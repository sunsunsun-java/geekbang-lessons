package org.geekbang.thinking.in.spring.aop.features.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * Aspect 配置类
 */
@Aspect
@Order
public class AspectConfiguration {
    
    @Pointcut("execution(public * *(..))") // 匹配 Join Point
    private void anyPublicMethod() {
        System.out.println("@Pointcut at any public method.");
    }
    
    @Around("anyPublicMethod()") // Join Point 拦截动作
    private Object aroundAnyPublicMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("@Around any public method.");
        return pjp.proceed();
    }
    
    @Before("anyPublicMethod()") // Join Point 拦截动作
    private void beforeAnyPublicMethod() {
        System.out.println("@Before any public method.");
    }
}