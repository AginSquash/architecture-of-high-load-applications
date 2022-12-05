package com.vladvrublevsky.laba1;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class MyServlet extends HttpServlet {
    private String message;
    //public static String login;
    public void init() {
        message = "Hello World! 22";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        final String firstName = request.getParameter("Login");
        final String lastName = request.getParameter("password");
        System.out.println(firstName);
    }

    public void destroy() {
    }
}