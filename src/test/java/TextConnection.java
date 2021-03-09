import java.sql.*;

public class TextConnection {

    public static void main(String[] args) {

        //  host 18.234.188.248
        //  port 1521
        //  sid xe
        //  username hr
        //  password hr
        // jdbc url AKA connection String
        // syntax
        // jdbc: vendorName: driverType @Yourhost:Port:SID
        // jdbc:oracle:thin:@18.234.188.248:1521:XE

        String url = "jdbc:oracle:thin:@18.234.188.248:1521:XE";
        try {
            Connection con = DriverManager.getConnection(url, "hr", "hr");

            System.out.println("CONNECTION SUCCESSFUL");
        }catch (SQLException e){
            System.out.println("CONNECTION HAS FAILED"+ e.getMessage());
        }

    }
}
