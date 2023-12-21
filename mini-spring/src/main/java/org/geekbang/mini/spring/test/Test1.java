package org.geekbang.mini.spring.test;

import org.geekbang.mini.spring.beans.BeansException;
import org.geekbang.mini.spring.context.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AService aService;
        BaseService baseService;
        try {
//            aService = (AService) context.getBean("aservice");

            baseService = (BaseService) context.getBean("baseservice");
            baseService.sayHello();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

}
