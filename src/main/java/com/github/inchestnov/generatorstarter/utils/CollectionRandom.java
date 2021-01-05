package com.github.inchestnov.generatorstarter.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import static com.github.inchestnov.generatorstarter.utils.CommonRandom.getRandomInteger;
import static com.github.inchestnov.generatorstarter.utils.Preconditions.checkNotNull;

public class CollectionRandom {

    public static <T> T getRandomValue(Collection<T> collection) {
        checkNotNull(collection);
        int randomIndex = getRandomInteger(collection.size() - 1);

        Iterator<T> iterator = collection.iterator();
        T random = null;
        while (randomIndex >= 0) {
            random = iterator.next();
            randomIndex--;
        }

        return random;
    }

    public static <K> K getRandomKey(Map<K, ?> map) {
        checkNotNull(map);
        return getRandomValue(map.keySet());
    }

    public static <V> V getRandomValue(Map<?, V> map) {
        checkNotNull(map);
        return getRandomValue(map.values());
    }

}
