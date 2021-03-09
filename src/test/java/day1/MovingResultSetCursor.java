package day1;

import java.sql.*;

public class MovingResultSetCursor {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@18.234.188.248:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm.executeQuery("SELECT * FROM REGIONS");
        /*
        These are the method of ResultSet object we can use to move the cursor accordingly
        This will only work if your result is type scroll insensitive
        rs.next();
        rs.previous();
        rs.first();
        rs.last();
        rs.beforeFirst();
        rs.afterLast();
        rs.absolute(3);
         */
        rs.first();
        System.out.println("First Row " + rs.getString( 2));
        rs.last();
        System.out.println("Last Row " + rs.getString(2));
        rs.previous();
        System.out.println("Previous Row "+ rs.getString(2));

        rs.beforeFirst();
        while (rs.next()){
            System.out.println("Second Column Data " + rs.getString(2));
        }
        // after the loop the cursor is at after last

        // move to second row from this point and print REGION_NAME
        rs.absolute(2);
        System.out.println("2nd Row REGION_NAME is " + rs.getString(2));



    }
}
