package com.github.inchestnov.generatorstarter;

import java.util.ArrayList;
import java.util.List;

public interface Generator {

    <T> T generate(Class<T> instanceClass);

    default <T> List<T> generate(Class<T> instanceClass, int count) {
        List<T> instances = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            instances.add(generate(instanceClass));
        }
        return instances;
    }

}
