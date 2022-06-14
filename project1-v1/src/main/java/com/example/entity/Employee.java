package com.example.entity;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private String firstName, lastName, emp_ID, password;

    private String email, phoneNum, address, birthDate;

    private EmpRole role;

    public Employee(String firstName, String lastName, String email, EmpRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emp_ID = emp_ID;
        this.email = email;

        this.password= RandomPassword.randomPassword();
    }

    public Employee() {
    }

    public EmpRole getRole() {
        return role;
    }

    public void setRole(EmpRole role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmp_ID() {
        return emp_ID;
    }

    public void setEmp_ID(String emp_ID) {
        this.emp_ID = emp_ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String toString() {
        return "ExpReimbursementReq{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emp_ID='" + emp_ID + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(emp_ID, employee.emp_ID) && Objects.equals(password, employee.password) && Objects.equals(email, employee.email) && Objects.equals(phoneNum, employee.phoneNum) && Objects.equals(address, employee.address) && Objects.equals(birthDate, employee.birthDate) && role == employee.role;
    }

    public int hashCode() {
        return Objects.hash(firstName, lastName, emp_ID, password, email, phoneNum, address, birthDate, role);
    }

    @Override
    public int compareTo(Employee o) {
        return this.emp_ID.compareTo(o.getEmp_ID());
    }
}
