/*
 * Separate class for handling connections to SQL database
 * Initial framework based on ChatGPT suggested code
 */

package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    
    //Class fields
    private Connection conn;
    private Statement statement;
    private String databaseFileName = "";

    //Constructor - Default location stored in calling class
    public DatabaseManager(String databaseInput) {

        if(associateWithDatabase(databaseFileName) == "0") {
            databaseFileName = databaseInput;
        }
        else {
            System.out.println("Error in building Database Manager");
        }

    } //End of Constructor with custom database location

    //Picks the database location that DatabaseManager should associate with
    public String associateWithDatabase(String databaseInput) {

        //Error message in case inputted database is the currently used one
        if(databaseInput == databaseFileName) {
            return "Selected Database is already in Use!";
        }

        try {

            //Start by closing the old connections
            conn.close();
            statement.close();

            //Then build the new
            conn = DriverManager.getConnection("jdbc:sqlite:" + databaseFileName);
            statement = conn.createStatement();
            return "0";

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "Error in Connecting to Database!";
        } //End Try/Catch
    } //End associateWithDatabase

    public void close() throws SQLException {
        statement.close();
        conn.close();
    } //End of close

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    } //End of executeQuery

    public int executeUpdate(String query) throws SQLException {
        return statement.executeUpdate(query);
    } //End of executeUpdate

    //Getter
    public String getDATABASE_FILE_NAME() {
        return databaseFileName;
    }

} //End of DatabaseManager
