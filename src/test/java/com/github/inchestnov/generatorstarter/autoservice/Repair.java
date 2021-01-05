package com.github.inchestnov.generatorstarter.autoservice;

import com.github.inchestnov.generatorstarter.Generated;

import java.util.Date;

@Generated(factory = RepairFactory.class)
public class Repair {

    private Service service;
    private Employee employee;
    private Date date;
    private State state;

    public enum State {
        NEW, IN_WORK, FINISHED
    }

    public Repair(Service service, Employee employee, Date date) {
        this.service = service;
        this.employee = employee;
        this.date = date;
    }

    public Service getService() {
        return service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Repair in service " + service + " by employee " + employee + " at " + date + ", state = " + state;
    }

}
