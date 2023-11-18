package org.geekbang.thinking.in.spring.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@MyComponent
public @interface MyComponent2 {
}
