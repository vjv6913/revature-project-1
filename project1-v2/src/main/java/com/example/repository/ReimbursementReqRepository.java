package com.example.repository;

import com.example.entity.ExpReimbursementReq;

import java.util.List;

public interface ReimbursementReqRepository {

    void save(ExpReimbursementReq expReimbursementReq);

    List<ExpReimbursementReq> findAll();

    List<ExpReimbursementReq> findAllByStatus(String status);

    List<ExpReimbursementReq> findAllByStatusForEmployee(String status, int empID);

    public List<ExpReimbursementReq> findAllResolved();

    List<ExpReimbursementReq> findAllResolvedForEmployee(int empID);

    void updateStatus(int expReimbursementReq, String status);
}
