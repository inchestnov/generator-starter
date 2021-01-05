package com.github.inchestnov.generatorstarter.autoservice;

import com.github.inchestnov.generatorstarter.Generated;

@Generated(factory = EmployeeFactory.class)
public class Employee {

    private String firstName;
    private String lastName;
    private Service service;

    public Employee(String firstName, String lastName, Service service) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.service = service;
    }

    public Service getService() {
        return service;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", from service " + service;
    }
}
