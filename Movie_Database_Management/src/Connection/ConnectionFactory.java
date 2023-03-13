package Connection;



import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mehul@504";
    private static final String URL = "jdbc:mysql://localhost:3306/projects";
    static Connection con = null;
    /**
     * @return
     */
    public static Connection getConnection() {
        try {
//               Connection con;


            if (con == null) {
                  Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + "projects", "root", "mehul@504");
//here sonoo is database name, root is username and password
                System.out.println("connection created....");


            }
        } catch (Exception e) {
            System.out.println("connection not made....");

        }
        return con;
    }
}
