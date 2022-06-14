package com.example.repository;

import com.example.datasource.SQLConnectionFactory;
import com.example.entity.ExpReimbursementReq;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class JdbcReimbursementReqRepository implements ReimbursementReqRepository{

    private static final Logger LOG= Logger.getLogger("ers"); // Logger is a singleton obj.

    public void save(ExpReimbursementReq expReimbursementReq) {

        LOG.info("saving new expense reimbursement request: ");
        try (Connection connection= SQLConnectionFactory.getConnection();){

            String sql = "insert into expreimrequest(amount, reimreason, status, emp_id) values (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1,expReimbursementReq.getAmount());
            ps.setString(2,expReimbursementReq.getReimReason());
            ps.setString(3,expReimbursementReq.getStatus().toString());
            ps.setString(4,expReimbursementReq.getEmployee().getEmp_ID());
            int rows = ps.executeUpdate();



        } catch (SQLException e) {
            LOG.error("error saving expense reimbursement request: ");
            e.printStackTrace();
        }

    }


    public List<ExpReimbursementReq> findAll() {
        LOG.info("finding all expense reimbursement requests: ");
        try (Connection connection= SQLConnectionFactory.getConnection();){

            String sql = "select * from expreimrequest";
            Statement ps = connection.createStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while(rs.next()){
                ExpReimbursementReq expReimbursementReq = new ExpReimbursementReq();
                expReimbursementReq.set
                // ******* @ 25.30 left in recording 6/8/22 2:17:13 PM
            }



        } catch (SQLException e) {
            LOG.error("error saving expense reimbursement request: ");
            e.printStackTrace();
        }
    }
}
