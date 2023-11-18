package org.geekbang.thinking.in.spring.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@MyComponent2
@MyConfiguration(name = "my-application")
public @interface MyApplication {
}
