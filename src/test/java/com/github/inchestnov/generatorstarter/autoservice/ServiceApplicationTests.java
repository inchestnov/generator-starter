package com.github.inchestnov.generatorstarter.autoservice;

import com.github.inchestnov.generatorstarter.Generator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ServiceApplicationTests {

    public static final int SERVICE_COUNT = 5;
    public static final int EMPLOYEE_COUNT = 25;
    @Autowired
    private Generator generator;

    @Test
    void contextLoads() {
        List<Service> services = generator.generate(Service.class, SERVICE_COUNT);
        List<Employee> employees = generator.generate(Employee.class, EMPLOYEE_COUNT);
        List<Repair> repairs = generator.generate(Repair.class, SERVICE_COUNT * EMPLOYEE_COUNT);

        // check that data is valid
        repairs.forEach(repair -> {
            Service service = repair.getService();
            Employee employee = repair.getEmployee();
            assertEquals(employee.getService().getName(), service.getName());
        });

        List<List<?>> instances = Arrays.asList(services, employees, repairs);
        instances.forEach(instanceList -> {
            instanceList.forEach(System.out::println);
            System.out.println();
        });
    }

}
