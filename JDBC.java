import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    private static final  String URL = "jdbc:mysql://localhost:3306/electricity_bill";
    private static final String USER = "root";
    private static final  String PASSWORD = "kapil";

    public static Connection getConnectionJDBC() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
