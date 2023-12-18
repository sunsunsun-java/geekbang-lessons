package org.geekbang.mini.spring.beans;

public class PropertyValue {
    private final String type;

    private final String name;

    private final Object value;

    public PropertyValue(String type, String name, Object value) {
        this.value = value;
        this.type = type;
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
