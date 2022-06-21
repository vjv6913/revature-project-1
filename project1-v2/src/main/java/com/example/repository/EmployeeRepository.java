package com.example.repository;

import com.example.entity.Employee;
import com.example.entity.ExpReimbursementReq;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    boolean authenticate (String username);

    boolean authenticate (String username, String password);
    List<Employee> findAll();
    Optional<Employee> findByEmpID(String number);

    Optional<Employee> findByEmpEmail(String email);

    void save(Employee employee);
    void update(Employee employee);

    Optional<Employee> empAuthentication(String username, String password);

}
