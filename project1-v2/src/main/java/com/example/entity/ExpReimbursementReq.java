package com.example.entity;

import java.time.*;
import java.util.Objects;


public class ExpReimbursementReq {

    private int id;
    private double amount;
    private String reimReason;
    private ERStatus status;
    private LocalDateTime localDateTime;

    private Employee employee;

    public ExpReimbursementReq(double amount, String reimReason, Employee employee) {
        this.amount = amount;
        this.reimReason = reimReason;
        this.status = status;
        this.employee = employee;
    }

    public ExpReimbursementReq() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if(amount>0)
            this.amount = amount;
        else
            this.amount=0;
    }

    public String getReimReason() {
        return reimReason;
    }

    public void setReimReason(String reimReason) {
        this.reimReason = reimReason;
    }

    public ERStatus getStatus() {
        if(this.status==null){
            this.status= ERStatus.valueOf("PENDING");
        }
        return status;
    }

    public void setStatus(ERStatus status) {
        this.status = status;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public String toString() {
        return "ExpReimbursementReq{" +
                "id=" + id +
                ", amount=" + amount +
                ", reimReason='" + reimReason + '\'' +
                ", status=" + status +
                ", emp_ID=" + employee.getEmp_ID() +
                '}';
    }
}
