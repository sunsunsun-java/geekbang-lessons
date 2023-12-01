package org.geekbang.thinking.in.spring.aop.features.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * Aspect XML 配置类
 */
public class AspectXmlConfig {
    
    private void beforeAnyPublicMethod() {
        System.out.println("@Before any public method.");
    }
    
    private Object aroundAnyPublicMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("@Around any public method : " + pjp.getSignature());
        return pjp.proceed();
    }

    private void afterReturningAnyPublicMethod() {
        System.out.println("@AfterReturning any public method.");
    }

    private void afterThrowingAnyPublicMethod() {
        System.out.println("@AfterThrowing any public method.");
    }

    private void finalizeAnyPublicMethod() {
        System.out.println("@After any public method.");
    }
}
