package day1;

import java.sql.*;

public class JDBC_FirstStep {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@ 3.85.213.97:1521:XE";
        try {
            Connection con = DriverManager.getConnection(url, "hr", "hr");
            // This way creating statement object, allows us to moe forward and backward easily
            // when navigating through the result we got
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

            // In order to access resultSet, we need to know which row we are at before entering
            // the first row, the cursor of the resultSet is at the location known as -- before first
            // in order to move to next line we need to call next method of resultSet
            // on order to get any column data we need to call method getString or getDouble .. and so on
            rs.next();
            // now we are the first row
            System.out.println("First Row REGION_NAME is " + rs.getString("REGION_NAME"));

            rs.next();
            System.out.println("Second Row REGION_NAME is " + rs.getString("REGION_NAME"));

            rs.next();
            System.out.println("Third Row REGION_NAME is " + rs.getString("REGION_NAME"));

            rs.next();
            System.out.println("Forth Row REGION_NAME is " + rs.getString("REGION_NAME"));

            rs.next(); // this will move the cursor to the location known as -- after last
            // Below line will not work! There is no row left
            //  System.out.println("FIFTH Row REGION_NAME is " + rs.getString("REGION_NAME"));


            System.out.println("CONNECTION SUCCESSFUL");
            rs.close();
            stmnt.close();
            con.close();

        }catch (SQLException e){
            System.out.println("CONNECTION HAS FAILED"+ e.getMessage());
        }




    }
}
