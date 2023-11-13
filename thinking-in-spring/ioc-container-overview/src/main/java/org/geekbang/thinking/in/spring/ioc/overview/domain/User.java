package org.geekbang.thinking.in.spring.ioc.overview.domain;

import org.geekbang.thinking.in.spring.ioc.overview.enums.City;
import org.springframework.beans.factory.BeanNameAware;

import java.util.Properties;

/**
 * 用户类
 */
public class User implements BeanNameAware {
    private Long id;
    private String name;

    private City city;

    private Company company;

    /**
     * 当前 Bean 的名称
     */
    private transient String beanName;

    private Properties context;

    private Properties contextAsText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Properties getContext() {
        return context;
    }

    public void setContext(Properties context) {
        this.context = context;
    }

    public Properties getContextAsText() {
        return contextAsText;
    }

    public void setContextAsText(Properties contextAsText) {
        this.contextAsText = contextAsText;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", company=" + company +
                ", beanName='" + beanName + '\'' +
                ", context=" + context +
                ", contextAsText=" + contextAsText +
                '}';
    }

    public static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("sunsun");
        return user;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
