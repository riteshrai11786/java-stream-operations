package com.ritesh.testcodes;

import com.ritesh.testcodes.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JavaStreamDemo {

    private static final Employee[] arrayOfEmployees = {
            new Employee(1, "Jeff", "Bezos", 100000.0),
            new Employee(2, "Bill", "Gates", 200000.0),
            new Employee(3, "Mark", "Zuckerberg", 300000.0)
    };


    public static void main(String [] args) {
        // Convert the array of employees to ArrayList. Old school way :)
        List<Employee> employeeList = Arrays.asList(arrayOfEmployees);
        System.out.print(employeeList);

        // Approach 1 is to Stream.of
        Stream.of(arrayOfEmployees[0], arrayOfEmployees[1], arrayOfEmployees[2])
                .forEach( emp -> System.out.print(emp.toString()));

        // Using the Stream builder
        Stream.Builder<Employee> empStreamBuilder = Stream.builder();

        // Insert the elements to the stream
        empStreamBuilder.accept(arrayOfEmployees[0]);
        empStreamBuilder.accept(arrayOfEmployees[1]);
        empStreamBuilder.accept(arrayOfEmployees[2]);

    }
}
