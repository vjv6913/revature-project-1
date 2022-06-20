package com.example.entity;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.Objects;
import java.util.Scanner;

import static com.example.Application.Cont;

public class Employee implements Comparable<Employee> {

    private String firstName, lastName, emp_ID, password;

    private String email, phoneNum, address, birthDate;

    private EmpRole role;

    public Employee(String firstName, String lastName, String email, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = EmpRole.valueOf(role);
        this.email = email;

        this.password= RandomPassword.randomPassword();
    }

    public Employee() {
    }

    public void viewEmpInfo(Employee emp){
        System.out.println("Employee ID #       : "+emp.getEmp_ID());
        System.out.println("Employee first name : "+emp.getFirstName());
        System.out.println("Employee last name  : "+emp.getLastName());
        System.out.println("Employee birthdate  : "+emp.getBirthDate());
        System.out.println("Employee role       : "+emp.getRole().toString());
        System.out.println("Employee email      : "+emp.getEmail());
        System.out.println("Employee phone #    : "+emp.getPhoneNum());
        System.out.println("Employee address    : "+emp.getAddress());

    }
    public void updateEmpInfo(String str, Employee emp){
        Scanner s = new Scanner(System.in);
        String input;
        String[] perInfo= new String[] {"first name","last name", "birthdate", "email", "phone #", "address"};
        String[] perInfoVal= new String[] {emp.getFirstName(), emp.getLastName(), emp.getBirthDate(), emp.getEmail(), emp.getPhoneNum(), emp.getAddress()};

        if(str.equals("password")){
            System.out.print("Would you like to update your password? ");
            if(Cont().equals("y")){
                System.out.print("Please enter your current password: ");
                input=s.nextLine();
                if(BCrypt.verifyer().verify(input.toCharArray(),emp.getPassword()).verified){
                    System.out.print("Please enter your new password:");
                    input=s.nextLine();
                    System.out.print("Please re-enter your new password:");
                    String input2=s.nextLine();
                    if(input.equals(input2)){
                        String bcryptHashString = BCrypt.withDefaults().hashToString(12, input.toCharArray());
                        emp.setPassword(bcryptHashString);
                    }else
                        System.out.println("Password unable to be reset");
                }
            }
        }else {
            for(int i=0; i<perInfo.length;i++){
                System.out.println("Employee "+perInfo[i]+" : "+perInfoVal[i]);
                System.out.print("Would you like to update your " + perInfo[i] + "? ");
                if (Cont().equals("y")) {
                    System.out.print("Please enter your " + perInfo[i] + ": ");
                    input = s.nextLine();

                    switch (perInfo[i]) {
                        case "firstname":
                            emp.setFirstName(input);
                            break;
                        case "lastname":
                            emp.setLastName(input);
                            break;
                        case "birthdate":
                            emp.setBirthDate(input);
                            break;
                        case "email":
                            emp.setEmail(input);
                            break;
                        case "phone #":
                            emp.setPhoneNum(input);
                            break;
                        case "address":
                            emp.setAddress(input);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
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

    public String getPassword() { return password; }

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
        return "Employee{" +
                "emp_ID='" + emp_ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address='" + address + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", role=" + role +
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


    public int compareTo(Employee o) {
        return this.emp_ID.compareTo(o.getEmp_ID());
    }
}
