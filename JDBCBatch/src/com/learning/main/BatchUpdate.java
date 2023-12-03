package com.learning.main;

import com.learning.util.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchUpdate {
    public static void main(String[] args) {
        Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs =null;

        try
        {
        connect = Utility.getConnection();
        if(connect!=null)
        {
            String query="update employee3 set company=? where id=?";
            stmt = connect.prepareStatement(query);
        }
        if(stmt!=null)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter id");
            int id = sc.nextInt();
            System.out.println("Please enter company");
            String company = sc.next();
            stmt.setString(1,company);
            stmt.setInt(2,id);
            stmt.addBatch(); // adding to the batch

            System.out.println("Please enter company");
            System.out.println("Please enter id");
            stmt.setString(1, sc.next());
            stmt.setInt(2, sc.nextInt());
            stmt.addBatch(); // adding to batch

            System.out.println("Please enter company");
            System.out.println("Please enter id");
            stmt.setString(1, sc.next());
            stmt.setInt(2, sc.nextInt());
            stmt.addBatch(); // adding to batch

            stmt.executeBatch(); // executing the batch.
            boolean result = stmt.execute();
            if(!result)
            {
               int noOfRowsEffected = stmt.getUpdateCount();
               if(noOfRowsEffected!=0)
                   System.out.println("Check DataBase");
            }
        }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try
            {
                Utility.closeResources(connect,stmt,rs);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
