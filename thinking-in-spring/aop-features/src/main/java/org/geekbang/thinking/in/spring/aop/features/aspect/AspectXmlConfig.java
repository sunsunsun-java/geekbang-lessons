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
}
