package com.example.week4.DatabaseManager;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnector {
    private static Connection connection;

    /**
     * Return the connection object
     * @return The connection object which connects to the database
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        if (connection==null || connection.isClosed())
        {
            createConnection();
        }
        return connection;
    }

    /**
     * Create a connection to the database
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private static void createConnection() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/assignment";
        String username="root";
        String password="Mysql123";
        connection=DriverManager.getConnection(url,username, password);
    }
}
