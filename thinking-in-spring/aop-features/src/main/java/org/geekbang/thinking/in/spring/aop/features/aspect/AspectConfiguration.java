package org.geekbang.thinking.in.spring.aop.features.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    @AfterReturning("anyPublicMethod()")
    // AspectJAfterReturningAdvice is AfterReturningAdvice
    // 一个 AfterReturningAdviceInterceptor 关联一个 AfterReturningAdvice
    // Spring 封装 AfterReturningAdvice -> AfterReturningAdviceInterceptor
    // AfterReturningAdviceInterceptor is MethodInterceptor
    // AfterReturningAdviceInterceptor
    //  -> AspectJAfterReturningAdvice
    //   -> AbstractAspectJAdvice#invokeAdviceMethodWithGivenArgs
    public void afterReturningAnyPublicMethod() {
        System.out.println("@AfterReturning any public method.");
    }

    @AfterThrowing("anyPublicMethod()")
    public void afterThrowingAnyPublicMethod() {
        System.out.println("@AfterThrowing any public method.");
    }

    @After("anyPublicMethod()")
    public void finalizeAnyPublicMethod() {
        System.out.println("@After any public method.");
    }
}
