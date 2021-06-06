package com.ritesh.testcodes.repository;

import com.ritesh.testcodes.model.Employee;

import java.util.List;

public class EmployeeRepository {
    private List<Employee> empList;

    public EmployeeRepository(List<Employee> empList) {
        this.empList = empList;
    }

    public Employee findById(int id) {
        for (Employee emp: empList) {
            if(emp.getEmployeeId() == id)
                return emp;
        }
        return null;
    }
}
