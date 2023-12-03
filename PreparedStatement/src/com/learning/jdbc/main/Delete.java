package com.learning.jdbc.main;

import com.learning.jdbc.util.Utility;

import java.sql.*;
import java.util.Scanner;

public class Delete {
    public static void main(String[] args)  {
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Utility.getConnection();
            if(connection!=null)
            {
                String query="delete from employee3 where id = ?";
                preparedStatement = connection.prepareStatement(query);
            }
            if(preparedStatement!=null)
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter id");
                int id = sc.nextInt();
                preparedStatement.setInt(1,id);
                preparedStatement.execute();
                int rowsEffected = preparedStatement.getUpdateCount();
                if(rowsEffected!=0)
                    System.out.println("Check the database");
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                Utility.closeResources(connection, preparedStatement, resultSet);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}

