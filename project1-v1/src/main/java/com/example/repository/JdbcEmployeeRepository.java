package com.example.repository;

import com.example.datasource.SQLConnectionFactory;
import com.example.entity.EmpRole;
import com.example.entity.Employee;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JdbcEmployeeRepository implements EmployeeRepository{

    private static final Logger LOG= Logger.getLogger("ers"); // Logger is a singleton obj.

    public Optional<Employee> findByEmpID(String number) {
        LOG.info("loading employee : "+number);
        try (Connection connection=SQLConnectionFactory.getConnection();){

            String sql = "select * from accounts where emp_ID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, number);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee();
                employee.setEmp_ID(rs.getString("emp_id"));
                employee.setFirstName(rs.getString("firstname"));
                employee.setLastName(rs.getString("lastname"));
                employee.setEmail(rs.getString("email"));
                employee.setPhoneNum(rs.getString("phone_num"));
                employee.setAddress(rs.getString("address"));
                employee.setBirthDate(rs.getString("birthdate"));
                employee.setPassword(rs.getString("pw"));
                employee.setRole(EmpRole.valueOf(rs.getString("emprole")));
                return Optional.of(employee);
            }

        } catch (SQLException e) {
            LOG.error("error loading account: "+number);
            e.printStackTrace();
        }
        return Optional.empty();
    }


    public void update(Employee employee) {

        LOG.info("updating employee : "+employee.getEmp_ID());
        try (Connection connection=SQLConnectionFactory.getConnection();){

            String sql = "update employees set firstname=? where emp_ID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getEmp_ID());
            int rows = ps.executeUpdate();

            sql = "update employees set lastname=? where emp_ID=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getLastName());
            ps.setString(2, employee.getEmp_ID());
            rows = ps.executeUpdate();

            sql = "update employees set email=? where emp_ID=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getEmail());
            ps.setString(2, employee.getEmp_ID());
            rows = ps.executeUpdate();

            sql = "update employees set phone_num=? where emp_ID=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getPhoneNum());
            ps.setString(2, employee.getEmp_ID());
            rows = ps.executeUpdate();

            sql = "update employees set address=? where emp_ID=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getAddress());
            ps.setString(2, employee.getEmp_ID());
            rows = ps.executeUpdate();

            sql = "update employees set birthdate=? where emp_ID=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getBirthDate());
            ps.setString(2, employee.getEmp_ID());
            rows = ps.executeUpdate();

            sql = "update employees set pw=? where emp_ID=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getPassword());
            ps.setString(2, employee.getEmp_ID());
            rows = ps.executeUpdate();

            sql = "update employees set emprole=? where emp_ID=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getRole().toString());
            ps.setString(2, employee.getEmp_ID());
            rows = ps.executeUpdate();

        } catch (SQLException e) {
            LOG.error("error updating employee: "+employee.getEmp_ID());
            e.printStackTrace();
        }

    }
}
