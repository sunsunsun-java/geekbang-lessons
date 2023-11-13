package org.geekbang.thinking.in.spring.data.binding;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.HashMap;

/**
 * {@link DataBinder} 示例
 */
public class DataBinderDemo {

    public static void main(String[] args) {
        User user = new User();
        DataBinder binder = new DataBinder(user, "");

        HashMap<String, Object> source = new HashMap<>();
        source.put("id", 1);
        source.put("name", "sun sun sun ");

        // PropertyValues 存在 User 中不存在属性值
        // DataBinder 特性1:忽略未知得属性
        source.put("age", 10);

        // a. PropertyValues 存在一个嵌套属性 Company.name
        // DataBinder 特性2:支持嵌套属性

        // b. PropertyValues 存在一个嵌套属性 Company.name
        // DataBinder 特性2:支持嵌套属性
        // Company company = new Company();
        // company.setName("geekbang");
        // user.setCompany(company);
//        source.put("company", new Company());
        source.put("company.name", "geekbang");

        MutablePropertyValues propertyValues = new MutablePropertyValues(source);

        // 1.调整 ignoreUnknownFields true (默认) -> false (抛异常，age 字段不存在)
//        binder.setIgnoreUnknownFields(false);

        // 2.调整 AutoGrowNestedPaths true (默认)
        binder.setAutoGrowNestedPaths(false);

        // 3.调整 ignoreInvalidFields false (默认) -> true (默认情况调整没有变化，需要调整 AutoGrowNestedPaths 为 false)
        binder.setIgnoreInvalidFields(true);

        binder.setRequiredFields("id", "name", "city");

        binder.bind(propertyValues);

        System.out.println(user);

        // 获取绑定结果（结果包含错误文案 code，不会抛出异常）
        BindingResult result = binder.getBindingResult();
        System.out.println(result);
    }

}
