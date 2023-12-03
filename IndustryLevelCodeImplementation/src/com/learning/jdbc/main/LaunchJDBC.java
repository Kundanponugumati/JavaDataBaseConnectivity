package com.learning.jdbc.main;

import com.learning.jdbc.util.Utility;

import java.sql.*;
import java.util.Scanner;

public class LaunchJDBC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            connect = Utility.getConnection();
            if(connect!=null)
                statement = connect.createStatement();
            if(statement!=null)
            {
//                String query ="select * from employee3";
                String query = sc.nextLine();
                boolean result = statement.execute(query);
                if(result)
                {
                    resultSet = statement.getResultSet();
                    if(resultSet!=null)
                    {
                        System.out.println("ID\tName\tSalary");
                        while (resultSet.next())
                        {
                            System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3));
                        }
                    }
                }
                else
                {
                    int noOfRowsEffected = statement.getUpdateCount();
                    if(noOfRowsEffected!=0)
                        System.out.println("Please Checked Your DB");
                }
            }
        }
        catch(SQLException sql)
        {
            sql.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try {
                Utility.closeResources(connect, statement, resultSet);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }

}
