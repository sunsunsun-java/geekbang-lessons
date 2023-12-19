package org.geekbang.mini.spring.test;

import org.geekbang.mini.spring.beans.BeansException;
import org.geekbang.mini.spring.context.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AService aService;
        try {
            aService = (AService) context.getBean("aservice");
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

}
