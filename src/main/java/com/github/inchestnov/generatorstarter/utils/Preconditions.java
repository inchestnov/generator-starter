package com.github.inchestnov.generatorstarter.utils;

public class Preconditions {

    public static final String DEFAULT_MESSAGE = "Object is null";

    public static void checkNotNull(Object object) {
        if (object == null)
            throw new IllegalArgumentException(DEFAULT_MESSAGE);
    }

    public static void checkNotNull(Object object, String message) {
        if (message == null)
            message = DEFAULT_MESSAGE;

        if (object == null)
            throw new IllegalArgumentException(message);
    }

    public static void checkNotNull(Object object, String template, Object... params) {
        checkNotNull(object, String.format(template, params));
    }

}
