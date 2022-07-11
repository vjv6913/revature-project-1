package com.example.web;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.entity.Employee;
import com.example.entity.ExpReimbursementReq;
import com.example.repository.EmployeeRepository;
import com.example.repository.JdbcEmployeeRepository;
import com.example.service.JavaMailUtil;
import org.apache.log4j.Logger;
import org.postgresql.util.PSQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = {"/updateEmpInfo", "/resetPW", "/registerEmployee"})
public class EmpServlet extends HttpServlet {

    private static final Logger LOG= Logger.getLogger("ers"); // Logger is a singleton obj.

    EmployeeRepository jdbcEmpRepo = new JdbcEmployeeRepository();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
        resp.sendRedirect("managerRegisterEmployee.jsp");
        //doPost(req,resp);

    }



        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //read input params from http-request
        HttpSession session = req.getSession();
        String currentUser = (String) session.getAttribute("current-user");
        if(currentUser!=null){


            Employee emp = jdbcEmpRepo.findByEmpEmail(currentUser).get();
            String reURI = req.getRequestURI();

            if (reURI.equals("/project1-v2/updateEmpInfo")) {


                String fname = req.getParameter("fname");
                String lname = req.getParameter("lname");
                String birthdate = req.getParameter("birthdate");
                String email = req.getParameter("email");
                String phonenumber = req.getParameter("phonenumber");
                String address = req.getParameter("address");


                if (!fname.isEmpty())
                    emp.setFirstName(fname);
                if (!lname.isEmpty())
                    emp.setLastName(lname);
                if (!birthdate.isEmpty())
                    emp.setBirthDate(birthdate);
                if (!email.isEmpty())
                    emp.setEmail(email);
                if (!phonenumber.isEmpty())
                    emp.setPhoneNum(phonenumber);
                if (!address.isEmpty())
                    emp.setAddress(address);

                jdbcEmpRepo.update(emp);

                req.setAttribute("emp", emp);
                req.getRequestDispatcher("employeeInformation.jsp").forward(req, resp);

            }

            if (reURI.equals("/project1-v2/resetPW")) {




                String currPW = req.getParameter("currPW");
                String newPW = req.getParameter("newPW");
                String reNewPW = req.getParameter("reNewPW");

                if (!newPW.isEmpty()) {

                    if (BCrypt.verifyer().verify(currPW.toCharArray(), emp.getPassword()).verified && newPW.equals(reNewPW)) {

                        String bcryptHashString = BCrypt.withDefaults().hashToString(12, newPW.toCharArray());
                        emp.setPassword(bcryptHashString);

                        jdbcEmpRepo.update(emp);

                        req.setAttribute("emp", emp);
                        req.getRequestDispatcher("employeeInformation.jsp").forward(req, resp);

                    }
                }


            }



            if (reURI.equals("/project1-v2/registerEmployee")) {
                //req.getRequestDispatcher("managerRegisterEmployee.jsp").forward(req, resp);

                try {

                    String fname = req.getParameter("fname");
                    String lname = req.getParameter("lname");
                    String email = req.getParameter("email");
                    String role = req.getParameter("role");


                    if (role.equals("1")) {
                        Employee emp9 = new Employee(fname, lname, email, "EMPLOYEE");
                        try {
                            jdbcEmpRepo.save(emp9);
                        }catch (Throwable e){
                            System.out.println(e.getMessage());
                            resp.sendRedirect("registrationFailed.html");

                            return;
                        }
                        JavaMailUtil.sendMail(emp9);

                        resp.sendRedirect("registrationSuccessful.html");


                    }else if (role.equals("2")) {
                        Employee emp9 = new Employee(fname, lname, email, "MANAGER");

                        try {
                            jdbcEmpRepo.save(emp9);
                        }catch (Throwable e){
                            resp.sendRedirect("registrationFailed.html");
                            return;
                        }
                        JavaMailUtil.sendMail(emp9);
                        resp.sendRedirect("registrationSuccessful.html");

                    }else {
                        resp.sendRedirect("registrationFailed.html");
                    }


                }catch (NullPointerException e) {

                    LOG.error("error getting to register employee: ");
                    req.getRequestDispatcher("registrationFailed.html").forward(req, resp);

                    e.printStackTrace();
                }



            }


        }else{
            resp.sendRedirect("index.html");
        }

    }

}
