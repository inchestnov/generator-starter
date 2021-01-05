package com.github.inchestnov.generatorstarter.autoservice;

import com.github.inchestnov.generatorstarter.Generated;

@Generated(factory = ServiceFactory.class)
public class Service {

    private String name;

    public Service(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
