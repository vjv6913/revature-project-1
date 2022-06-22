package com.example.web;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.repository.JdbcEmployeeRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@WebServlet(urlPatterns = {"/updateEmpInfo", "/resetPW", "/registerEmp"})
public class EmpServlet extends HttpServlet {

    EmployeeRepository jdbcEmpRepo = new JdbcEmployeeRepository();


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



            if (reURI.equals("/project1-v2/registerEmp")) {




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


        }else{
            resp.sendRedirect("index.html");
        }

    }

}
