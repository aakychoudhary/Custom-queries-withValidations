package com.example.queries.repository;


import com.example.queries.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value = "SELECT * FROM employees WHERE department = dept ORDER BY salary DESC", nativeQuery = true)
    List<Employee> findByDepartmentNative(@Param("dept") String department);

}