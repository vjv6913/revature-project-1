package com.example.repository;

import com.example.datasource.SQLConnectionFactory;
import com.example.entity.ERStatus;
import com.example.entity.Employee;
import com.example.entity.ExpReimbursementReq;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcReimbursementReqRepository implements ReimbursementReqRepository{

    private static final Logger LOG= Logger.getLogger("ers"); // Logger is a singleton obj.

    public void save(ExpReimbursementReq expReimbursementReq) {

        LOG.info("saving new expense reimbursement request: ");
        try (Connection connection= SQLConnectionFactory.getConnection();){

            String sql = "insert into expreimrequest(amount, reimreason, status, emp_id) values (?,?,'PENDING',?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1,expReimbursementReq.getAmount());
            ps.setString(2,expReimbursementReq.getReimReason());
            //ps.setString(3,"PENDING");
            ps.setInt(3,Integer.parseInt(expReimbursementReq.getEmployee().getEmp_ID()));
            int rows = ps.executeUpdate();

        } catch (SQLException e) {
            LOG.error("error saving expense reimbursement request: ");
            e.printStackTrace();
        }

    }

    public List<ExpReimbursementReq> findAll() {

        LOG.info("Finding all expense reimbursement requests:");
        List<ExpReimbursementReq> expReimbursementReqList = new ArrayList<>();
        try (Connection connection= SQLConnectionFactory.getConnection();){

            String sql = "select * from expreimrequest";
            Statement ps = connection.createStatement();
            ResultSet rs= ps.executeQuery(sql);

            expReimbursementReqList=rsMagic(rs);

        } catch (SQLException e) {
            LOG.error("error finding all expense reimbursement requests: ");
            e.printStackTrace();
        }

        return expReimbursementReqList;
    }

    public List<ExpReimbursementReq> findAllByStatus(String status) {
        return findAllByStatusForEmployee(status, -1);
    }

    public List<ExpReimbursementReq> findAllByStatusForEmployee(String status, int empID) {
        if(empID!=-1) {
            LOG.info("Finding all expense reimbursement requests by status for particular employee ID: "+empID);
        }else{
            LOG.info("Finding all expense reimbursement requests foll all employees:");
        }

        List<ExpReimbursementReq> expReimbursementReqList = new ArrayList<>();
        try (Connection connection= SQLConnectionFactory.getConnection();){

            ResultSet rs;

            if(empID==-1) {
                String sql="select * from expreimrequest where status=?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1,status);
                rs= ps.executeQuery();
            }else {
                String sql="select * from expreimrequest where status=? and emp_id=?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1,status);
                ps.setInt(2,empID);
                rs= ps.executeQuery();
            }

            expReimbursementReqList=rsMagic(rs);
        } catch (SQLException e) {
            if(empID==-1){
                LOG.error("error saving all expense reimbursement requests by status: ");
            }else {
                LOG.error("error saving expense reimbursement requests by status for empID: " + empID);
            }
            e.printStackTrace();
        }

        return expReimbursementReqList;
    }

    public List<ExpReimbursementReq> rsMagic(ResultSet rs) throws SQLException {
        List<ExpReimbursementReq> expReimbursementReqList = new ArrayList<>();
        while (rs.next()) {
            ExpReimbursementReq expReimbursementReq = new ExpReimbursementReq();
            expReimbursementReq.setId(rs.getInt("request_id"));
            expReimbursementReq.setAmount(rs.getDouble("amount"));
            expReimbursementReq.setReimReason(rs.getString("reimreason"));
            expReimbursementReq.setStatus(ERStatus.valueOf(rs.getString("status")));
            //expReimbursementReq.setLocalDateTime();
            expReimbursementReq.setEmployee((new JdbcEmployeeRepository()).findByEmpID(rs.getString("emp_id")).get());
            expReimbursementReqList.add(expReimbursementReq);
        }

        System.out.println(expReimbursementReqList);
        return expReimbursementReqList;
    }

    public List<ExpReimbursementReq> findAllResolved() {
        return findAllResolvedForEmployee(-1);
    }

    public List<ExpReimbursementReq> findAllResolvedForEmployee(int empID) {

        ResultSet rs;
        LOG.info("Finding all expense reimbursement requests by status for particular employee:");
        List<ExpReimbursementReq> expReimbursementReqList = new ArrayList<>();
        try (Connection connection= SQLConnectionFactory.getConnection();){
            String sql;
            if(empID==-1) {
                sql = "select * from expreimrequest where status!='PENDING'";
                Statement ps = connection.createStatement();
                rs = ps.executeQuery(sql);
            }else {
                sql = "select * from expreimrequest where status!='PENDING' and emp_id=?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, empID);
                rs= ps.executeQuery();
            }

            expReimbursementReqList=rsMagic(rs);

        } catch (SQLException e) {
            LOG.error("error saving expense reimbursement requests by status: ");
            e.printStackTrace();
        }

        return expReimbursementReqList;
    }

    public void updateStatus(ExpReimbursementReq expReimbursementReq, String status) {

        LOG.info("updating expense reimbursement request status : "+expReimbursementReq.getId());
        try (Connection connection=SQLConnectionFactory.getConnection();){

            String sql = "update expreimrequest set status=? where request_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,status);
            ps.setInt(2, expReimbursementReq.getId());
            int rows = ps.executeUpdate();


        } catch (SQLException e) {
            LOG.error("error updating expense reimbursement request status : "+expReimbursementReq.getId());
            e.printStackTrace();
        }

    }

}
