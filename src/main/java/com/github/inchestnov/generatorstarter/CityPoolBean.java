package com.github.inchestnov.generatorstarter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class CityPoolBean extends AbstractStringPool implements CityPool {

    @Value("cities.txt")
    private Resource resource;

    @Override
    protected Resource getResource() {
        return resource;
    }

    @Override
    public String getRandomCityName() {
        return getRandomValue();
    }

}
