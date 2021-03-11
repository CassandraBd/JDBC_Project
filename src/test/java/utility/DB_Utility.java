package utility;

import java.sql.*;

public class DB_Utility {

    private static Connection con;
    private static Statement stm ;
    private static ResultSet rs ;

    /*
    Create connection method, just checking one connection is successful or not
    static Connection con make it static field so we can reuse in every methods we write
     */

    public static void createConnection(){

        String url = ConfigurationReader.getProperty("hr.database.url");
        String username = ConfigurationReader.getProperty("hr.database.username");
        String password = ConfigurationReader.getProperty("hr.database.password");

        try {
            con = DriverManager.getConnection(url , username, password) ;
            System.out.println("CONNECTION SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED " + e.getMessage() );
        }


    }

    /**
     * Create Connection by jdbc url and username , password provided
     * @param url
     * @param username
     * @param password
     */
    public static void createConnection(String url , String username, String password){


        try {
            con = DriverManager.getConnection(url, username, password) ;
            System.out.println("CONNECTION SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED " + e.getMessage() );
        }

    }

/*
Run the sql query provided and return ResultSet object
@param sql
@return ResultSet object that contains the data
 */
    public static ResultSet runQuery(String sql){

        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        }catch(SQLException e){
            System.out.println("ERROR OCCURRED WHILE RUNNING QUERY "+ e.getMessage() );
        }

        return rs ;

    }

/*
Destroy method to clean up all the resources after being used
 */
    public static void destroy(){
        // We have to catch if we have the valid object first before closing the resource
        // Because we can not take action on am object that does not exist
        try {
            if(rs!=null) rs.close();
            if(stm!=null) stm.close();
            if(con!=null) con.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while closing resources "+e.getMessage());
        }
    }

    /*
      find out the row count
    @return row count of this ResultSet
     */
    public static int getRowCount(){
        int rowCount = 0;
        try {
            rs.last();
            rowCount = rs.getRow();
        } catch (SQLException e) {
            System.out.println("Error occurred while getting row count");
        }
        return rowCount;
    }



}
