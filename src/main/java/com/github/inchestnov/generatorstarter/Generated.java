package com.github.inchestnov.generatorstarter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Generated {

    Class<? extends Factory<?>> factory();

}
