package com.github.inchestnov.generatorstarter;

import com.github.inchestnov.generatorstarter.utils.CommonRandom;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AgePoolBean implements AgePool {

    @Value("${generator.random.min-age:18}")
    private Integer minAge;

    @Value("${generator.random.max-age:60}")
    private Integer maxAge;

    @Override
    public int getRandomAge() {
        return CommonRandom.getRandomIntegerBetween(minAge, maxAge);
    }

}
