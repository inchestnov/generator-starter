package com.github.inchestnov.generatorstarter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class SurnamePoolBean extends AbstractStringPool implements SurnamePool {

    @Value("classpath:surnames.txt")
    private Resource resource;

    @Override
    protected Resource getResource() {
        return resource;
    }

    @Override
    public String getRandomSurname() {
        return getRandomValue();
    }

}
