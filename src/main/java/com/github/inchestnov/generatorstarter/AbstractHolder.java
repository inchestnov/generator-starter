package com.github.inchestnov.generatorstarter;

import com.github.inchestnov.generatorstarter.utils.CollectionRandom;
import com.github.inchestnov.generatorstarter.utils.CommonRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class AbstractHolder<T> implements Holder<T> {

    private List<T> instances = new ArrayList<>();

    @Override
    public void add(T instance) {
        instances.add(instance);
    }

    @Override
    public T getRandom() {
        return instances.get(CommonRandom.getRandomInteger(instances.size() - 1));
    }

    @Override
    public T getFirst(Predicate<T> predicate) {
        return instances.stream().filter(predicate).findFirst().orElseThrow();
    }

    @Override
    public List<T> getAll() {
        return Collections.unmodifiableList(instances);
    }

    public T getRandomByPredicate(Predicate<T> predicate) {
        return CollectionRandom.getRandomValue(getByPredicate(predicate));
    }

    @Override
    public List<T> getByPredicate(Predicate<T> predicate) {
        return instances.stream().filter(predicate).collect(Collectors.toUnmodifiableList());
    }

}
