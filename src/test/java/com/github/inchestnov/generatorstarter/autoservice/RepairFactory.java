package com.github.inchestnov.generatorstarter.autoservice;

import com.github.inchestnov.generatorstarter.AbstractFactory;
import com.github.inchestnov.generatorstarter.Holder;
import com.github.inchestnov.generatorstarter.utils.CommonRandom;
import com.github.inchestnov.generatorstarter.utils.DateRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class RepairFactory extends AbstractFactory<Repair> {

    @Autowired
    private RepairHolder repairHolder;

    @Autowired
    private ServiceHolder serviceHolder;

    @Autowired
    private EmployeeHolder employeeHolder;

    @Override
    protected Repair createInstance() {
        Service service = serviceHolder.getRandom();
        Employee employee = employeeHolder.getRandomByPredicate(e -> service.equals(e.getService()));

        Repair repair = new Repair(service, employee, DateRandom.getRandomDateInMonth(2020, Calendar.JULY));
        repair.setState(CommonRandom.getRandomEnum(Repair.State.class));
        return repair;
    }

    @Override
    protected Holder<Repair> getHolder() {
        return repairHolder;
    }
}
