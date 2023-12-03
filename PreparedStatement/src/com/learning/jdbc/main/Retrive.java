package com.learning.jdbc.main;

import com.learning.jdbc.util.Utility;

import java.sql.*;
import java.util.Scanner;

public class Retrive {
    public static void main(String[] args)  {
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Utility.getConnection();
            if(connection!=null)
            {
                String query="select * from employee3 where name=?";
                preparedStatement = connection.prepareStatement(query);
            }
            if(preparedStatement!=null)
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter name");
                String name = sc.next();
                preparedStatement.setString(1,name);
                preparedStatement.execute();
                resultSet=preparedStatement.getResultSet();
            }
            if(resultSet!=null)
            {
                while(resultSet.next())
                {
                    System.out.println(resultSet.getInt(1)+"\t"+
                            resultSet.getString(2)+"\t"+resultSet.getInt(3));
                }
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

