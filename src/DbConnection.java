
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static final String url="jdbc:mysql://localhost:3306/student_db";
    public static final String user ="root";
    public static final String password="YOUR_MYSQL_PASSWORD";
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }
}
