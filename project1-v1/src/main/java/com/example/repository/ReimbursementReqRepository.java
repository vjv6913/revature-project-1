package com.example.repository;

import com.example.entity.ExpReimbursementReq;

import java.util.List;

public interface ReimbursementReqRepository {

    void save(ExpReimbursementReq expReimbursementReq);

    List<ExpReimbursementReq> findAll();
}
