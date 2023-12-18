package org.geekbang.mini.spring.beans;

import java.util.ArrayList;
import java.util.List;

public class ArgumentValues {
    private final List<ArgumentValue> argumentValues = new ArrayList<>();

    public ArgumentValues() {
    }

    public void addArgumentValue(ArgumentValue argumentValue) {
        this.argumentValues.add(argumentValue);
    }

    public ArgumentValue getIndexedArgumentValue(int index) {
        ArgumentValue argumentValue = this.argumentValues.get(index);
        return argumentValue;
    }

    public int getArgumentCount() {
        return this.argumentValues.size();
    }

    public boolean isEmpty() {
        return this.argumentValues.isEmpty();
    }
}
