package com.github.inchestnov.generatorstarter.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.github.inchestnov.generatorstarter.utils.Preconditions.checkNotNull;

public class CommonRandom {

    public static int getRandomInteger(int bound) {
        return ThreadLocalRandom.current().nextInt(bound + 1);
    }

    public static long getRandomLong(long bound) {
        return ThreadLocalRandom.current().nextLong(bound + 1);
    }

    public static double getRandomDouble(double bound) {
        return ThreadLocalRandom.current().nextDouble(bound + 1);
    }

    public static int getRandomIntegerBetween(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static long getRandomLongBetween(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max + 1);
    }

    public static double getRandomDoubleBetween(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max + 1);
    }

    public static Date getRandomDateInYear(int year) {
        return DateRandom.getRandomDateInYear(year);
    }

    public static Date getRandomDateInMonth(int year, int month) {
        return DateRandom.getRandomDateInMonth(year, month);
    }

    public static Date getRandomDateBetween(Date min, Date max) {
        return DateRandom.getRandomDateBetween(min, max);
    }

    public static boolean getRandomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    public static <T> T getRandomValue(Collection<T> collection) {
        return CollectionRandom.getRandomValue(collection);
    }

    public static <K> K getRandomKey(Map<K, ?> map) {
        return CollectionRandom.getRandomKey(map);
    }

    public static <V> V getRandomValue(Map<?, V> map) {
        return CollectionRandom.getRandomValue(map.values());
    }

    public static <T extends Enum<T>> T getRandomEnum(Class<? extends Enum<T>> enumClass) {
        checkNotNull(enumClass);
        return (T) getRandomValue(Arrays.asList(enumClass.getEnumConstants()));
    }

}
