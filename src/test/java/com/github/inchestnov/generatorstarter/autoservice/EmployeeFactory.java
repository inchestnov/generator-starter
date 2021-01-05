package com.github.inchestnov.generatorstarter.autoservice;

import com.github.inchestnov.generatorstarter.AbstractFactory;
import com.github.inchestnov.generatorstarter.Holder;
import com.github.inchestnov.generatorstarter.NamePool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFactory extends AbstractFactory<Employee> {

    @Autowired
    private EmployeeHolder employeeHolder;

    @Autowired
    private ServiceHolder serviceHolder;

    @Autowired
    private NamePool namePool;

    @Override
    protected Employee createInstance() {
        return new Employee(namePool.getRandomName(), namePool.getRandomSurname(), serviceHolder.getRandom());
    }

    @Override
    protected Holder<Employee> getHolder() {
        return employeeHolder;
    }
}
