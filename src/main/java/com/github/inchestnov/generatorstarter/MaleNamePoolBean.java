package com.github.inchestnov.generatorstarter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class MaleNamePoolBean extends AbstractStringPool implements MaleNamePool {

    @Value("classpath:male-names.txt")
    private Resource resource;

    @Override
    protected Resource getResource() {
        return resource;
    }

    @Override
    public String getRandomMaleName() {
        return getRandomValue();
    }

}
