package com.learning.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Hello world!");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/jdbc";
        String userName="root";
        String password="root@123";
        Connection connect =  DriverManager.getConnection(url,userName,password);
        System.out.println("end");
    }
}