package org.geekbang.thinking.in.spring.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@MyComponentScan
public @interface MyComponentScan2 {
    @AliasFor(annotation = MyComponentScan.class, attribute = "scanBasePackages") // 隐性别名
    String[] basePackages() default {};

    // @MyComponentScan2.basePackages
    // -> @MyComponentScan.scanBasePackages
    // -> @ComponentScan.value
    // -> @ComponentScan.basePackages

    /**
     * 与元注解 @MyComponentScan 同名属性 (隐性覆盖)
     * @return
     */
    String[] scanBasePackages() default {};

    @AliasFor("scanBasePackages")
    String[] packages() default {}; // packages 覆盖了 scanBasePackages 覆盖了元注解 scanBasePackages
}
