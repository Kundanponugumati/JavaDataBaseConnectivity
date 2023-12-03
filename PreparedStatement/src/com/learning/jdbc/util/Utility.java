package com.learning.jdbc.util;

import java.sql.*;

public class Utility {
    // load and registering the driver
    static {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    // connection.
    public static Connection getConnection() throws SQLException {
        String url="jdbc:mysql://localhost:3306/jdbc";
        String userName="root";
        String password="root@123";
        return DriverManager.getConnection(url,userName,password);
    }

    //closing the resources
    public static void closeResources(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if(connection!=null)
            connection.close();
        if(statement!=null)
            statement.close();
        if(resultSet!=null)
            resultSet.close();
    }
}
