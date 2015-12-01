/**
 * Created by gamerszvidx on 29-11-2015.
 */
import java.math.BigInteger;
import java.sql.*;

public class DBconnector {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/CSV";

    static final String USER = "root";
    static final String PASS = "";

    static ResultSet rs;
        static Connection conn = null;
        static Statement stmt = null;
    public static void ConnectToDB(){
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connect to database..");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();}}
    public static ResultSet RunQuery(String Query) throws SQLException {
            System.out.println("Create statement...");
            stmt = conn.createStatement();
            String sql;
            sql = Query;
            rs = stmt.executeQuery(sql);
        return rs;
    }




    }

