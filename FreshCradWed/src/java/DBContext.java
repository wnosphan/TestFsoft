import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class DBContext {
    protected Connection connection;
    public DBContext()
    {
        try {
            String url = "jdbc:sqlserver://LAPTOP-H3FVBJCP\\MSSQLSERVER01:1433;databaseName=Items;encrypt=false";
            String username = "sa";
            String password = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
    
}