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
        out.println("<h2>"+"Welcome user\nCurrent Date & Time: " +date.toString()+"</h2>");
        out.close();
    }
}
