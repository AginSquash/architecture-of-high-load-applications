package com.vladvrublevsky.laba1;
import jakarta.servlet.*;

public class CreateTableServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent e) {
        CreateTable.init();
    }

    public void contextDestroyed(ServletContextEvent e) {

    }
}
