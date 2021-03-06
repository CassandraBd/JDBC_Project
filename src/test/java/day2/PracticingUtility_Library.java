package day2;

import utility.ConfigurationReader;
import utility.DB_Utility;

public class PracticingUtility_Library {
    public static void main(String[] args) {

        String url = ConfigurationReader.getProperty("library1.database.url");
        String username = ConfigurationReader.getProperty("library1.database.username");
        String  password = ConfigurationReader.getProperty("library1.database.password");

        DB_Utility.createConnection(url, username, password);

        DB_Utility.runQuery("SELECT COUNT(*) FROM books");
        DB_Utility.displayAllData();

        System.out.println("First Row First Column Value is " + DB_Utility.getFirstRowFirstColumn());

        DB_Utility.runQuery("SELECT * FROM books");

        System.out.println("DB_Utility.getRowCount() = " + DB_Utility.getRowCount());
        System.out.println("DB_Utility.getColumnCount() = " + DB_Utility.getColumnCount());

        DB_Utility.destroy();


    }
}
