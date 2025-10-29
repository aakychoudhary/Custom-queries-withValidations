package com.example.queries.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required ")
    private String name;


    private String department;

    @Positive(message = "Salary should be above  0")
    @Max(value = 1000000, message = "Salary not accessed 1,000,000")
    private double salary;



}
