package com.vladvrublevsky.laba1;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class WelcomeUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        java.util.Date date = new java.util.Date();
        out.println("Welcome User. Current Date & Time: " +date.toString());
        out.close();
    }
}
