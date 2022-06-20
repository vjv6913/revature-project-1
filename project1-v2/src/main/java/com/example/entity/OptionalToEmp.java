package com.example.entity;

import java.util.Optional;

public class OptionalToEmp {

    public static Employee getEmployee(Optional<Employee> e){
        Employee emp = new Employee();
        if(e!=null) {
            emp.setEmp_ID(e.get().getEmp_ID());
            emp.setRole(e.get().getRole());
            emp.setPassword(e.get().getPassword());
            emp.setBirthDate(e.get().getBirthDate());
            emp.setFirstName(e.get().getFirstName());
            emp.setLastName(e.get().getLastName());
            emp.setAddress(e.get().getAddress());
            emp.setPhoneNum(e.get().getPhoneNum());
            emp.setRole(e.get().getRole());
            return emp;
        }else
            return null;
    }
}
