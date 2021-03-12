package day2;

import utility.ConfigurationReader;
import utility.DB_Utility;

public class PracticingUtility_BookIT {
    public static void main(String[] args) {

        String url      = ConfigurationReader.getProperty("bookit.database.url");
        String username = ConfigurationReader.getProperty("bookit.database.username");
        String password = ConfigurationReader.getProperty("bookit.database.password");

        DB_Utility.createConnection(url, username, password);

        DB_Utility.runQuery("SELECT * FROM room") ;
        DB_Utility.displayAllData();

        DB_Utility.destroy();


    }
}
