package com.example.web;

import com.example.datasource.SQLConnectionFactory;
import com.example.entity.ExpReimbursementReq;
import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.repository.JdbcEmployeeRepository;
import com.example.repository.JdbcReimbursementReqRepository;
import com.example.repository.ReimbursementReqRepository;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/SubmitReimbursement", "/ViewReimbursement"})
public class ReimServlet extends HttpServlet {

    private static final Logger LOG= Logger.getLogger("ers"); // Logger is a singleton obj.

    ReimbursementReqRepository jdbcReimRepo = new JdbcReimbursementReqRepository();
    EmployeeRepository jdbcEmpRepo = new JdbcEmployeeRepository();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }




    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //read input params from http-request
        HttpSession session = req.getSession();
        String currentUser = (String) session.getAttribute("current-user");
        if(currentUser != null){

            ExpReimbursementReq request = new ExpReimbursementReq();
            Employee emp = jdbcEmpRepo.findByEmpEmail(currentUser).get();
            String reURI = req.getRequestURI();

            if (reURI.equals("/project1-v2/SubmitReimbursement")) {


                String amount = req.getParameter("amount");
                String reason = req.getParameter("reason");

                if (!amount.isEmpty() && !reason.isEmpty()) {
                    request.setAmount(Double.parseDouble(amount));
                    request.setReimReason(reason);
                    request.setEmployee(emp);
                    jdbcReimRepo.save(request);
                }

                req.getRequestDispatcher("employeeSubmitRequest.jsp").forward(req, resp);

            }
            if (reURI.equals("/project1-v2/ViewReimbursement")) {

                try {

                    List<ExpReimbursementReq> allRec = jdbcReimRepo.findAllByStatusForEmployee("PENDING", Integer.parseInt(emp.getEmp_ID()));
                    System.out.println(allRec);

                    req.setAttribute("all-PENDING", allRec);
                    req.setAttribute("emp", emp);

                    req.getRequestDispatcher("employeeReimbursements.jsp").forward(req, resp);
                }catch (NullPointerException e) {

                        LOG.error("error getting list or reimbursements requests by status for empID: ");
                        resp.sendRedirect("employeeHome.jsp");

                    e.printStackTrace();
                }



            }

        } else {
            resp.sendRedirect("index.html");
        }

    }

}

//for(int i=0; i < allRec.size(); i++){