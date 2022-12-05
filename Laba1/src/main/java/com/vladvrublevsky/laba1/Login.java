package com.vladvrublevsky.laba1;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        AuthResult AR = Validate.checkUser(login, pass);
        if(AR == AuthResult.unsuccessful)
        {
            out.println("Username or Password incorrect");
            RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.include(request, response);
        }
        else
        {
            if (AR == AuthResult.successful) {
                RequestDispatcher rs = request.getRequestDispatcher("Welcome");
                rs.forward(request, response);
            } else if (AR == AuthResult.Isuperuser ){
                RequestDispatcher rs = request.getRequestDispatcher("Welcome2");
                rs.forward(request, response);
            }
        }
    }
}