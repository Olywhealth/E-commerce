package com.ecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    final static String url = "jdbc:mysql://localhost:3306/decagon";
    final static String USERNAME = "root";
    final static String PASSWORD = "password";

    private static Connection connection;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
        return connection;
    }


}
