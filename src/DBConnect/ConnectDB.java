package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    private static String url = "jdbc:mysql://localhost:3306/driverlicense";
    private static String username = "root";
    private static String password = "root";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }
}
