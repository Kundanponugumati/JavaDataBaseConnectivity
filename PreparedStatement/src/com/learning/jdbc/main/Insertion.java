package com.learning.jdbc.main;

import com.learning.jdbc.util.Utility;

import java.sql.*;
import java.util.Scanner;

public class Insertion {
    public static void main(String[] args)  {
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Utility.getConnection();
            if(connection!=null)
            {
                String query="insert into employee3 (id,name,salary,company) values(?,?,?,?)";
                preparedStatement = connection.prepareStatement(query);
            }
            if(preparedStatement!=null)
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter id");
                int id = sc.nextInt();
                System.out.println("Please enter name");
                String name = sc.next();
                System.out.println("Please enter salary");
                float salary = sc.nextFloat();
                System.out.println("Please enter company");
               String company =  sc.next();
               preparedStatement.setInt(1,id);
               preparedStatement.setString(2,name);
               preparedStatement.setFloat(3,salary);
               preparedStatement.setString(4,company);

               boolean result = preparedStatement.execute();
               if(result)
                   resultSet=preparedStatement.getResultSet();
               else
               {
                   int rowsEffected = preparedStatement.getUpdateCount();
                   if(rowsEffected!=0)
                       System.out.println("Check the database");
               }
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
