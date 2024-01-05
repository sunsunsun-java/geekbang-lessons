package org.geekbang.thinking.in.spring.aop.features.event;

import org.springframework.context.ApplicationEvent;

/**
 * 动作已执行的事件
 */
public class ExecutedEvent extends ApplicationEvent {

    public ExecutedEvent(Object source) {
        super(source);
    }
}
