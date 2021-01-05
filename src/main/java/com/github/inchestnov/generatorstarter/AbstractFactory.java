package com.github.inchestnov.generatorstarter;

public abstract class AbstractFactory<T> implements Factory<T> {

    @Override
    public T create() {
        T instance = createInstance();

        init(instance);

        Holder<T> instanceHolder = getHolder();
        if (instanceHolder != null)
            instanceHolder.add(instance);

        return instance;
    }

    protected abstract T createInstance();

    protected void init(T instance) {

    }

    protected Holder<T> getHolder() {
        return null;
    }

}
