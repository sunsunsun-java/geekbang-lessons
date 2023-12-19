package org.geekbang.mini.spring.beans;

public class PropertyValue {
    private final String type;

    private final String name;

    private final Object value;

    private final boolean isRef;

    public PropertyValue(String type, String name, Object value, boolean isRef) {
        this.value = value;
        this.type = type;
        this.name = name;
        this.isRef = isRef;
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

    public boolean isRef() {
        return isRef;
    }
}
