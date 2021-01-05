package com.github.inchestnov.generatorstarter;

import java.util.List;
import java.util.function.Predicate;

public interface Holder<T> {

    void add(T instance);

    T getRandom();

    T getFirst(Predicate<T> predicate);

    List<T> getAll();

    List<T> getByPredicate(Predicate<T> predicate);

}
