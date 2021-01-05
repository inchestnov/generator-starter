package com.github.inchestnov.generatorstarter.autoservice;

import com.github.inchestnov.generatorstarter.AbstractFactory;
import com.github.inchestnov.generatorstarter.CityPool;
import com.github.inchestnov.generatorstarter.Holder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory extends AbstractFactory<Service> {

    @Autowired
    private ServiceHolder serviceHolder;

    @Autowired
    private CityPool cityPool;

    @Override
    protected Service createInstance() {
        return new Service(cityPool.getRandomCityName());
    }

    @Override
    protected Holder<Service> getHolder() {
        return serviceHolder;
    }
}
