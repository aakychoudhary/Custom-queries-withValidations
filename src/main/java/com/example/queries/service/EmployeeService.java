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


        if (employee.getName() != null) {
            employee.setName(employee.getName().trim());
        }
        if (employee.getEmail() != null) {
            employee.setEmail(employee.getEmail().trim().toLowerCase());
        }
        if (employee.getDepartment() != null) {
            employee.setDepartment(employee.getDepartment().trim());
        }


        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new IllegalArgumentException("Email already exists in the system: " + employee.getEmail());
        }
        return employeeRepository.save(employee);
    }

}
