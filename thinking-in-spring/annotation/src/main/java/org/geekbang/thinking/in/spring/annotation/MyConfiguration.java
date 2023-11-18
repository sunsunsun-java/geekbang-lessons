package org.geekbang.thinking.in.spring.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface MyConfiguration {

    /**
     * 名称属性
     * @return
     */
    String name();
}
