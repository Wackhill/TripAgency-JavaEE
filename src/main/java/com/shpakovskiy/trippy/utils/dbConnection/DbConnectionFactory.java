package com.shpakovskiy.trippy.utils.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionFactory {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                //TODO: Move data to private config file
                Class.forName ("com.mysql.cj.jdbc.Driver").newInstance();
                String userName = "remote_user";
                String password = "1234567eight";
                String url = "jdbc:MySQL://db4free.net:3306/trippy_db?serverTimezone=Europe/Minsk&useSSL=false";
                connection = DriverManager.getConnection (url, userName, password);
                System.out.println ("\nDatabase Connection Established...");    //TODO: Add logging
            } catch (Exception e) {
                System.out.println("DB connection failed");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
