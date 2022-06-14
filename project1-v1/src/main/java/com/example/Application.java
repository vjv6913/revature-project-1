package com.example;

import com.example.entity.EmpRole;
import com.example.entity.Employee;
import com.example.entity.RandomPassword;
import com.example.repository.EmployeeRepository;
import com.example.repository.JdbcEmployeeRepository;

import java.util.Optional;

public class Application {

    public static void main(String[] args) {
        //Employee emp = new Employee("Vincent", "Ramos", "me@gmail.com", );
        EmployeeRepository empRepo= new JdbcEmployeeRepository();
        Optional<Employee> emp =empRepo.findByEmpID("1");
        System.out.println(emp);


    }
}
