import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gamerszvidx on 1-12-2015.
 */
public class UpTime {
    static List Units = new ArrayList();
    static List Values = new ArrayList();
    public static void main(String[] args) throws SQLException {
        DBconnector.ConnectToDB();
        DBconnector.RunQuery("select DISTINCT UnitID from connections");
        while(DBconnector.rs.next()) {
            long UnitID = DBconnector.rs.getLong("UnitID");
            Units.add(UnitID);
            System.out.println(UnitID);
        }
        DBconnector.rs.close();
        System.out.println("array");
        for (Object unit : Units){
            System.out.println(unit);
        }
        for (Object unit : Units) {
            DBconnector.RunQuery("select SUM(Value) as Value from connections where UnitID = " + unit);
            while (DBconnector.rs.next()) {
                Object value = DBconnector.rs.getObject("Value");
                System.out.println("value");
                Values.add(value);
            }
        }
        for (Object Value : Values){
            System.out.println(Value);
        }
    }

}
