package com.example.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //read input params from http-request

        String uName= req.getParameter("uname");

        //process request

        String message="Hello "+uName;

        //generate http-response

        //resp.setContentType("text/html");

        req.setAttribute("message",message);

        req.getRequestDispatcher("login-response.jsp").forward(req, resp);



    }

}
