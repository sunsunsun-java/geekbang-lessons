package org.geekbang.thinking.in.spring.aop.features;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

public class ThrowsAdviceDemo {

    public static void main(String[] args) {
        ThrowsAdviceDemo throwsAdviceDemo = new ThrowsAdviceDemo();
        ProxyFactory proxyFactory = new ProxyFactory(throwsAdviceDemo);
        proxyFactory.addAdvice(new MyThrowsAdvice());
        ThrowsAdviceDemo proxy = (ThrowsAdviceDemo) proxyFactory.getProxy();
        proxy.execute();
    }

    public void execute() {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new RuntimeException("For Purpose...");
        }
        System.out.println("Executing...");
    }
}
