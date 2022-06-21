package com.example.web;

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

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    EmployeeRepository jdbcEmpRepo = new JdbcEmployeeRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //read input params from http-request

        String uName= req.getParameter("username");
        String pw= req.getParameter("password");

        boolean b=jdbcEmpRepo.authenticate(uName,pw);
        if(!b){
            resp.sendRedirect("index.html");
        }else{
            Optional<Employee> emp = jdbcEmpRepo.findByEmpEmail(uName);
            HttpSession session = req.getSession();


            session.setAttribute("current-user", uName);

            if(emp.get().getRole().toString().equals("EMPLOYEE")) {
                //resp.sendRedirect("WEB-INF/employeeHome.html");
                req.getRequestDispatcher("employeeHome.html").forward(req,resp);
            }else if(emp.get().getRole().toString().equals("MANAGER")){
                //resp.sendRedirect("WEB-INF/managerHome.html");
                req.getRequestDispatcher("managerHome.html").forward(req,resp);
            }else {
                resp.sendRedirect("index.html");
            }
        }

        //resp.sendRedirect("employeeHome.html");



        /*String message="Hello "+uName+pw;

        //generate http-response

        //resp.setContentType("text/html");

        req.setAttribute("message",message);

        req.getRequestDispatcher("login-response.jsp").forward(req, resp);*/

    }

}
