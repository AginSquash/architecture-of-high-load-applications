package com.vladvrublevsky.laba1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        // Open a connection

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB","root","MyNewPass");
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " login VARCHAR(255), " +
                    " passHash VARBINARY(255), " +
                    " PRIMARY KEY ( login ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            stmt.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
