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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@WebServlet(urlPatterns = {"/reimbursements", "/employeeHome", "/submitRequest", "/employeeInfo"})
public class HeaderServlet extends HttpServlet{

    EmployeeRepository jdbcEmpRepo = new JdbcEmployeeRepository();


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println(session.isNew());
        System.out.println(session.getId());
        System.out.println(new Date(session.getCreationTime()));
        System.out.println(new Date(session.getLastAccessedTime()));

        String currentUser = (String) session.getAttribute("current-user");
        System.out.println(currentUser);
        System.out.println(req.getRequestURI());
        if(currentUser != null) {
            Employee emps = jdbcEmpRepo.findByEmpEmail(currentUser).get();
            System.out.println(emps);

            req.setAttribute("emp", emps);

            String reURI = req.getRequestURI();
            // read
            if (reURI.equals("/project1-v2/reimbursements")) {
                req.getRequestDispatcher("employeeReimbursements.jsp").forward(req, resp);
            }
            if (reURI.equals("/project1-v2/employeeHome")) {
                resp.sendRedirect("employeeHome.html");
            }
            if (reURI.equals("/project1-v2/submitRequest")) {
                req.getRequestDispatcher("employeeSubmitRequest.jsp").forward(req, resp);
                //resp.sendRedirect("employeeSubmitRequest.jsp");
            }
            if (reURI.equals("/project1-v2/employeeInfo")) {
                req.getRequestDispatcher("employeeInformation.jsp").forward(req, resp);
            }

        }else{
            resp.sendRedirect("index.html");
        }

        //processRequest(req, resp);
        //req.getRequestDispatcher("/WEB-INF/employeeReimbursements.html").forward(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqPath = req.getRequestURI();
        String httpMethod = req.getMethod();
        if (httpMethod.equals("GET") && reqPath.equals("/project1-v1/reimbursements")) {


            req.getRequestDispatcher("employeeReimbursements.jsp").forward(req, resp);
        }
        if (httpMethod.equals("POST") && reqPath.equals("/project1-v1/reimbursements")) {
            //resp.sendRedirect("reimbursements");
            req.getRequestDispatcher("employeeReimbursements.jsp").forward(req, resp);
        }
        //req.getRequestDispatcher("employeeReimbursements.jsp").forward(req, resp);
        if (httpMethod.equals("GET") && reqPath.equals("/project1-v1/employeeHome")) {


            req.getRequestDispatcher("employeeHome.html").forward(req, resp);
        }
        if (httpMethod.equals("POST") && reqPath.equals("/project1-v1/employeeHome")) {
            //resp.sendRedirect("employeeHome");
            req.getRequestDispatcher("employeeHome.html").forward(req, resp);
        }
    }


    /*protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //read input params from http-request

        HttpSession session = req.getSession();
        System.out.println(session.isNew());
        System.out.println(session.getId());
        System.out.println(new Date(session.getCreationTime()));
        System.out.println(new Date(session.getLastAccessedTime()));

        String currentUser = (String) session.getAttribute("username");

        System.out.println(currentUser);


        boolean b = jdbcEmpRepo.authenticate(currentUser);
        if (!b) {
            resp.sendRedirect("index.html");
        } else {
            Optional<Employee> emp = jdbcEmpRepo.findByEmpEmail(currentUser);

            if (emp.get().getRole().toString().equals("EMPLOYEE")) {
                //resp.sendRedirect("WEB-INF/employeeHome.html");
                req.getRequestDispatcher("WEB-INF/employeeHome.html").forward(req, resp);
            } else if (emp.get().getRole().toString().equals("MANAGER")) {
                //resp.sendRedirect("WEB-INF/managerHome.html");
                req.getRequestDispatcher("WEB-INF/managerHome.html").forward(req, resp);
            } else {
                resp.sendRedirect("index.html");
            }
        }

        //resp.sendRedirect("employeeHome.html");


        String message = "Hello " + uName + pw;

        //generate http-response

        //resp.setContentType("text/html");

        req.setAttribute("message", message);

        req.getRequestDispatcher("login-response.jsp").forward(req, resp);

    }*/

}
