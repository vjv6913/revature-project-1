package com.example.repository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.datasource.SQLConnectionFactory;
import com.example.entity.ERStatus;
import com.example.entity.EmpRole;
import com.example.entity.Employee;
import com.example.entity.ExpReimbursementReq;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcEmployeeRepository implements EmployeeRepository{

    private static final Logger LOG= Logger.getLogger("ers"); // Logger is a singleton obj.



   /* public boolean authenticate(String username, String password) {

        LOG.info("loading employee : " + username + " to authenticate password.");
            try (Connection connection = SQLConnectionFactory.getConnection();) {

                String sql = "select * from employees where email=?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, username);
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

                    if (BCrypt.verifyer().verify(password.toCharArray(), employee.getPassword()).verified) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } catch (SQLException e) {
                LOG.error("error loading account: " + username + "for authentication");
                e.printStackTrace();
            }

        return false;
    }*/

    public boolean authenticate(String username) {
        LOG.info("loading employee : "+username +" to authenticate password.");
        try (Connection connection=SQLConnectionFactory.getConnection();){

            String sql = "select * from employees where email=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee();
                //employee.setEmp_ID(rs.getString("emp_id"));
                //employee.setFirstName(rs.getString("firstname"));
                //employee.setLastName(rs.getString("lastname"));
                employee.setEmail(rs.getString("email"));
                //employee.setPhoneNum(rs.getString("phone_num"));
                //employee.setAddress(rs.getString("address"));
                //employee.setBirthDate(rs.getString("birthdate"));
                //employee.setPassword(rs.getString("pw"));
                //employee.setRole(EmpRole.valueOf(rs.getString("emprole")));

                if(username.equals(employee.getEmail()))
                {
                    return true;
                }
                else
                {
                    return false;
                }

            }

        } catch (SQLException e) {
            LOG.error("error loading account: "+username+ "for authentication");
            e.printStackTrace();
        }
        System.out.println("Username not found");
        return false;
    }

    public boolean authenticate(String username, String password) {
        LOG.info("loading employee : "+username +" to authenticate password.");
        try (Connection connection=SQLConnectionFactory.getConnection();){

            String sql = "select * from employees where email=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
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

                if(BCrypt.verifyer().verify(password.toCharArray(),employee.getPassword()).verified)
                {
                    System.out.println("Authentication Successful");
                    return true;
                }
                else
                {
                    return false;
                }

            }

        } catch (SQLException e) {
            LOG.error("error loading account: "+username+ "for authentication");
            e.printStackTrace();
        }
        System.out.println("Username not found");
        return false;
    }

    public List<Employee> findAll() {
        LOG.info("Finding all employees:");
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection= SQLConnectionFactory.getConnection();){

            String sql = "select * from employees where emprole='EMPLOYEE'";
            Statement ps = connection.createStatement();
            ResultSet rs= ps.executeQuery(sql);
            while(rs.next()){
                Employee emp = new Employee();
                emp.setEmp_ID(rs.getString("emp_id"));
                emp.setFirstName(rs.getString("firstname"));
                emp.setLastName(rs.getString("lastname"));
                emp.setEmail(rs.getString("email"));
                emp.setPhoneNum(rs.getString("phone_num"));
                emp.setAddress(rs.getString("address"));
                emp.setBirthDate(rs.getString("birthdate"));
                emp.setPassword(rs.getString("pw"));
                emp.setRole(EmpRole.valueOf(rs.getString("emprole")));
                employeeList.add(emp);
            }





        } catch (SQLException e) {
            LOG.error("error finding all expense reimbursement requests: ");
            e.printStackTrace();
        }

        return employeeList;
    }

    public Optional<Employee> findByEmpID(String number) {
        LOG.info("loading employee : "+number);
        try (Connection connection=SQLConnectionFactory.getConnection();){

            String sql = "select * from employees where emp_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(number));
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

    public Optional<Employee> findByEmpEmail(String email) {
        LOG.info("loading employee : "+email);
        try (Connection connection=SQLConnectionFactory.getConnection();){

            String sql = "select * from employees where email=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
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
            LOG.error("error loading account: "+email);
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void save(Employee employee) {

        LOG.info("saving new employee :");
        try (Connection connection=SQLConnectionFactory.getConnection();){

            String sql = "insert into employees(firstname, lastname, email, pw, emprole) values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmail());
            ps.setString(4, BCrypt.withDefaults().hashToString(12, employee.getPassword().toCharArray()));
            ps.setString(5, employee.getRole().toString());
            int rows = ps.executeUpdate();


        } catch (SQLException e) {
            LOG.error("error updating employee: "+employee.getEmp_ID());
            e.printStackTrace();
        }

    }

    public void update(Employee employee) {

        LOG.info("updating employee : "+employee.getEmp_ID());
        try (Connection connection=SQLConnectionFactory.getConnection();){

            String sql = "update employees set firstname=?,lastname=?, email=?, phone_num=?, address=?, birthdate=?, pw=?, emprole=? where emp_ID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getPhoneNum());
            ps.setString(5, employee.getAddress());
            ps.setString(6, employee.getBirthDate());
            ps.setString(7, employee.getPassword());
            ps.setString(8, employee.getRole().toString());
            ps.setInt(9, Integer.parseInt(employee.getEmp_ID()));
            int rows = ps.executeUpdate();


        } catch (SQLException e) {
            LOG.error("error updating employee: "+employee.getEmp_ID());
            e.printStackTrace();
        }

    }

    @Override
    public Optional<Employee> empAuthentication(String username, String password) {
        LOG.info("loading employee : "+username +" to authenticate password.");
        try (Connection connection=SQLConnectionFactory.getConnection();){

            String sql = "select * from employees where email=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
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

                if(BCrypt.verifyer().verify(password.toCharArray(),employee.getPassword()).verified)
                {
                    System.out.println("Authentication Successful");
                    return Optional.of(employee);
                }
                else
                {
                    System.out.println("Authentication password incorrect");
                }

            }

        } catch (SQLException e) {
            LOG.error("error loading account: "+username+ "for authentication");
            e.printStackTrace();
        }
        System.out.println("Username not found");
        return Optional.empty();
    }


    public Optional<Employee> findByEmployeeEmail(String username) {
        LOG.info("loading employee : "+username +" to authenticate password.");
        try (Connection connection=SQLConnectionFactory.getConnection();){

            String sql = "select * from employees where email=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
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

                if(BCrypt.verifyer().verify(employee.getPassword().toCharArray(),employee.getPassword()).verified)
                {
                    System.out.println("Authentication Successful");
                    return Optional.of(employee);
                }
                else
                {
                    System.out.println("Authentication password incorrect");
                }

            }

        } catch (SQLException e) {
            LOG.error("error loading account: "+username+ "for authentication");
            e.printStackTrace();
        }
        System.out.println("Username not found");
        return Optional.empty();

    }



}
