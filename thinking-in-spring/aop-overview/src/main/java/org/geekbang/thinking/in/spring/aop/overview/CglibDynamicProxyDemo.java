package org.geekbang.thinking.in.spring.aop.overview;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB 动态代理示例
 */
public class CglibDynamicProxyDemo {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        // 指定 super class = DefaultEchoService.class
        enhancer.setSuperclass(DefaultEchoService.class);
        // 指定拦截接口
        enhancer.setInterfaces(new Class[]{EchoService.class});
        enhancer.setCallback((MethodInterceptor) (source, method, args1, methodProxy) -> {
            long startTime = System.currentTimeMillis();
            // Source -> CGLIB 子类
            // 目标类  -> DefaultEchoService
            Object result = methodProxy.invokeSuper(source, args1);
            long costTime = System.currentTimeMillis() - startTime;
            System.out.println("[CGLIB 字节码提升] echo 方法执行的实现：" + costTime + " ms.");
            return result;
        });

        // 创建代理对象
        EchoService echoService = (EchoService) enhancer.create();
        // 输出执行结果
        System.out.println(echoService.echo("Hello,World"));
    }


}
