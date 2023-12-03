import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/jdbc";
        String userName="root";
        String password="root@123";
        Connection connect =  DriverManager.getConnection(url,userName,password);
        Statement statement = connect.createStatement();
        String query = "create table employee3 (id int,name varchar(20),salary float,company varchar(20))";
        statement.executeUpdate(query);
        String query2="insert into employee3 (id,name,salary,company) " +
                "values (1,'kundan',200,'Apple'),(3,'preetham',100,'Qualcomm'),(5,'Sriram',150,'Microsoft')";
        int noOfRowsEffected = statement.executeUpdate(query2);
        if(noOfRowsEffected!=0)
            System.out.println("Check DataBase Update Operation Successful");
        else
            System.out.println("Nothing happened in DataBase");
    }
}
