package controllers;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Alexander Vashurin on 1/26/17.
 */
public class DBUtility {
    private static Connection connection = null;

    public static Connection getConnection() throws Exception {
        if (connection != null)
            return connection;
        else {
            // Store the database URL in a string
            String serverName = "127.0.0.1";
            String portNumber = "5432";
            String sid = "rtdb";
            String dbUrl = "jdbc:postgresql://" + serverName + ":" + portNumber
                     + "/" + sid;
            Class.forName("org.postgresql.Driver");

            // set the url, username and password for the databse
            connection = DriverManager.getConnection(dbUrl, "postgres", "postgres");
            return connection;
        }
    }
}
