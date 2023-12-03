import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteOperation {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/jdbc";
        String userName="root";
        String password="root@123";
        Connection connect =  DriverManager.getConnection(url,userName,password);
        Statement statement = connect.createStatement();
        String query="delete from studentdetails where id=4 and name='preetham'";
        int noOfRowsEffected = statement.executeUpdate(query);
        if(noOfRowsEffected!=0)
            System.out.println("Check DataBase Update Operation Successful");
        else
            System.out.println("Nothing happened in DataBase");
    }
}
