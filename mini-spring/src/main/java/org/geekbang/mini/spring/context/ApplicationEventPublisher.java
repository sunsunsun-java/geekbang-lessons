package org.geekbang.mini.spring.context;

public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
