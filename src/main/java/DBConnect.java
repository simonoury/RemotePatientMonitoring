
import java.sql.*;
public class DBConnect {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public DBConnect() {
        String url = "jdbc:postgresql://hjcqaohuagengm:6ca336e996e214db564e5871a756e3cf5567db550d0e033f903225c7da2ee5f7@ec2-46-137-113-157.eu-west-1.compute.amazonaws.com:5432/d9reln7n11dkvn?sslmode=require&user=user&password=pass";
        String user = "hjcqaohuagengm";
        String pass = "6ca336e996e214db564e5871a756e3cf5567db550d0e033f903225c7da2ee5f7";
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Successful");
            //conn.close();
        }catch (Exception ex){
            System.out.println("Error  " + ex);
        }
    }
}