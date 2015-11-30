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


    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connect to database..");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Create statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT Distinct UnitID FROM connections";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                long UnitID = rs.getLong("UnitID");
                System.out.println(UnitID);
            }
            rs.close();
            stmt.close();
            conn.close();

        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    //hello

}