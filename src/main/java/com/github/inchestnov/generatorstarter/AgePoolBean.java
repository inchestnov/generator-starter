package com.github.inchestnov.generatorstarter;

import com.github.inchestnov.generatorstarter.utils.CommonRandom;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AgePoolBean implements com.github.inchestnov.generatorstarter.AgePool {

    @Value("${generator.random.min-age}")
    private Integer minAge;

    @Value("${generator.random.max-age}")
    private Integer maxAge;

    @Override
    public int getRandomAge() {
        return CommonRandom.getRandomIntegerBetween(minAge, maxAge);
    }

}
