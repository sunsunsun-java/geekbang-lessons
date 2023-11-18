package org.geekbang.thinking.in.spring.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component // 元注解, 实现 @Component "派生性"
public @interface MyComponent {
}
