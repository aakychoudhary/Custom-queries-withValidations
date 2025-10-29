package com.example.queries.service;


import com.example.queries.entity.Employee;
import com.example.queries.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartmentNative(department);
    }




    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
