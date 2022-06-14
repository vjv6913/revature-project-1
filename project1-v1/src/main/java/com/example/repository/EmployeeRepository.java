package com.example.repository;

import com.example.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> findByEmpID(String number);
    void update(Employee employee);

}
