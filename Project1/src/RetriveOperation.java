
import java.sql.*;

public class RetriveOperation {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1. load and register the driver.
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2. Establish Connection.
        String url="jdbc:mysql://localhost:3306/jdbc";
        String userName="root";
        String password="root@123";
        Connection connect =  DriverManager.getConnection(url,userName,password);

        //3. Create Statement.
        Statement statement = connect.createStatement();

        //4. Execute Query
        String query="select * from studentdetails";
        ResultSet rs = statement.executeQuery(query);

        //5. process the resultset.
        System.out.println("id"+"\t"+"name"+"\t" +"age");
        while(rs.next())
        {
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"
                    +rs.getInt(3));
        }

        //6. close the resources
        rs.close();
        statement.close();
        connect.close();

    }
}
