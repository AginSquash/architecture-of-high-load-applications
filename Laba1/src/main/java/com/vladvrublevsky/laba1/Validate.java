package com.vladvrublevsky.laba1;

import java.sql.*;

enum AuthResult {
    unsuccessful,
    successful,
    Isuperuser
}
public class Validate {
    public static AuthResult checkUser(String login,String pass)
    {
        AuthResult AR = AuthResult.unsuccessful;
        try {
            // drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB","root","MyNewPass");
            PreparedStatement ps = con.prepareStatement("select * from USERS where login=? and pass=?");
            ps.setString(1, login);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getBoolean("isSuperUser")) {
                    return AuthResult.Isuperuser;
                } else {
                    return  AuthResult.successful;
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return AR;
    }
}
