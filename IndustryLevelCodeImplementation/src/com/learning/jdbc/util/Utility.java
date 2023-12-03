package com.learning.jdbc.util;

import java.sql.*;

public class Utility {

    // step-1: we are writing in static block because it gets executed during class loading itself.
    static
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        System.out.println("Loaded and Registered the Driver.");
    }

    // step-2: connection establishment
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String userName = "root";
        String password = "root@123";
       return DriverManager.getConnection(url,userName,password);
    }

    //last step: closing the resources.
    public static void closeResources(Connection connect , Statement statement, ResultSet resultSet) throws SQLException {
        if(connect!=null)
            connect.close();
        if(statement!=null)
            statement.close();
        if(resultSet!=null)
            resultSet.close();
    }
}
