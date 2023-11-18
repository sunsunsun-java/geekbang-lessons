package org.geekbang.thinking.in.spring.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"org/geekbang/thinking/in/spring/annotation/HelloWorldConfiguration"}; // 导入
    }
}
