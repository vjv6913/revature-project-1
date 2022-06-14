package com.example.entity;

import java.time.*;
import java.util.Objects;


public class ExpReimbursementReq {

    private int id;
    private int amount;
    private String reimReason;
    private ERStatus status;
    private LocalDateTime localDateTime;

    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getReimReason() {
        return reimReason;
    }

    public void setReimReason(String reimReason) {
        this.reimReason = reimReason;
    }

    public ERStatus getStatus() {
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

    @Override
    public String toString() {
        return "ExpReimbursementReq{" +
                "id=" + id +
                ", amount=" + amount +
                ", reimReason='" + reimReason + '\'' +
                ", status=" + status +
                ", localDateTime=" + localDateTime +
                ", employee=" + employee +
                '}';
    }
}
