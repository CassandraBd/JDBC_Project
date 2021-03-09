package day1;

import java.sql.*;

public class LoopingResultSet {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@18.234.188.248:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm.executeQuery("SELECT * FROM REGIONS");

       // rs.next();
       // System.out.println("Region Value at this row is " + rs.getString("REGION_NAME"));

        while (rs.next()) {
            System.out.println("REGION_ID at this row is " + rs.getString("REGION_ID"));
            System.out.println("Region Value at this row is " + rs.getString("REGION_NAME"));

        }

        // Create new resultSet object by running different query like SELECT * FROM JOBS
        // get job_id ant title iin on line
         rs = stm.executeQuery("SELECT * FROM JOBS");

        // rs.getString has overloaded version
        // and you can use column index instead of column names

        while(rs.next() ){
            // get job_id and title in one line
            System.out.print( rs.getString(1) );
            System.out.println("\t\t "  +  rs.getString(2));

        }
           // System.out.println("JOB_ID at this row is " + rs.getString("JOB_ID"));
         //   System.out.println("JOB_TITLE at this row is " + rs.getString("JOB_TITLE"));

        }


    }

