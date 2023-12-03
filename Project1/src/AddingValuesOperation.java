import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddingValuesOperation {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/jdbc";
        String userName="root";
        String password="root@123";
        Connection connect =  DriverManager.getConnection(url,userName,password);
        Statement statement = connect.createStatement();
        String query="insert into studentdetails (id,name,age) " +
                "values (4,'preetham',20),(5,'yeses',24),(6,'dinesh',23)";
        int noOfRowsEffected = statement.executeUpdate(query);
        if(noOfRowsEffected!=0)
            System.out.println("Check DataBase Update Operation Successful");
        else
            System.out.println("Nothing happened in DataBase");
    }
}
