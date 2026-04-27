package com.prince;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    private static Connection con = null;

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {

                Properties prop = new Properties();

                InputStream input = DBConnection.class
                        .getClassLoader()
                        .getResourceAsStream("db.properties");

                if (input == null) {
                    System.out.println("db.properties file not found!");
                    return null;
                }

                prop.load(input);

                String url = prop.getProperty("db.url");
                String user = prop.getProperty("db.username");
                String pass = prop.getProperty("db.password");

                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(url, user, pass);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
