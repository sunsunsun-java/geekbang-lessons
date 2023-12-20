package org.geekbang.mini.spring.beans.factory.config;

import org.geekbang.mini.spring.beans.factory.config.ConstructorArgumentValue;

import java.util.ArrayList;
import java.util.List;

public class ConstructorArgumentValues {
    private final List<ConstructorArgumentValue> constructorArgumentValues = new ArrayList<>();

    public ConstructorArgumentValues() {
    }

    public void addArgumentValue(ConstructorArgumentValue constructorArgumentValue) {
        this.constructorArgumentValues.add(constructorArgumentValue);
    }

    public ConstructorArgumentValue getIndexedArgumentValue(int index) {
        ConstructorArgumentValue constructorArgumentValue = this.constructorArgumentValues.get(index);
        return constructorArgumentValue;
    }

    public int getArgumentCount() {
        return this.constructorArgumentValues.size();
    }

    public boolean isEmpty() {
        return this.constructorArgumentValues.isEmpty();
    }
}
