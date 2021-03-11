package day1;

import java.sql.*;

public class ResultSetNextMethod {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@18.234.188.248:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm.executeQuery("SELECT * FROM REGIONS");

       // rs.beforeFirst();
        while(rs.next()){
          //  System.out.println(rs.next()); don't do bc moves cursor
            System.out.println("rs.getString(1) = " + rs.getString(1));
        }
        // There are two ways to get cell data
        // 1. Using column name for ResultSet object's getString(column name here)
        // 2. Using column index for ResultSet object's getString(column index here)
        //    SQL Index Starts With 1!!!!

        // How do you loop backwards from last row till first row
      //  rs.afterLast();
        while (rs.previous()){
            System.out.println("Backward rs.getString(1) = " + rs.getString(1));
        }



    }
}
