package com.vladvrublevsky.laba1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "root", "MyNewPass");
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " login VARCHAR(255), " +
                    " pass VARCHAR(255), " + // тут бы соль+хэш но так лень...... как-нибудь потом?
                    " isSuperUser BIT, " +
                    " PRIMARY KEY ( login ))";

            stmt.executeUpdate(sql);
            System.out.println("Table created");

            stmt.executeUpdate("INSERT IGNORE INTO REGISTRATION " + "VALUES (1001, 'Simpson', '123', 1)");
            stmt.executeUpdate("INSERT IGNORE INTO REGISTRATION " + "VALUES (1002, 'Mcbeal', '456', 0)");
            stmt.executeUpdate("INSERT IGNORE INTO REGISTRATION " + "VALUES (1003, 'Flinstone', '789', 0)");
            stmt.executeUpdate("INSERT IGNORE INTO REGISTRATION " + "VALUES (1004, 'Cramden', '000', 1)");

            System.out.println("Values inserted");
            stmt.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
