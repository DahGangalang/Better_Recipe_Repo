package src;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringJoiner;

public class RecipeCore {

    //Defaul calues for program
    private final static String DEFAULTDATABSELOCATION = "recipe.db";
    
    //Function for displaying the main menu
    private static void showMenu() {

        StringJoiner menuOutput = new StringJoiner("\n", "\n\n", "\n>");
        menuOutput.add("Main Menu");
        menuOutput.add("------------------------------------");
        menuOutput.add("1 - Diplay Titles in Data Base");
        menuOutput.add("2 - Search Data Base");
        menuOutput.add("3 - Add Recipe from File to database");
        menuOutput.add("4 - Add new Recipe via GUI");
        menuOutput.add("0 - Exit");

        System.out.printf("%s", menuOutput.toString());
    } //End ShowMenu

    public static void main(String[] args) {
        
        //Initialize variables for main program loop
        Scanner scanner = new Scanner(System.in);
        String userChoice;
        DatabaseManager dbm = new DatabaseManager(DEFAULTDATABSELOCATION);

        //Main program loop - in try/catch for error handling
        try {
            do {

                showMenu();
                userChoice = scanner.nextLine();

                //1 - Diplay Titles in Data Base
                //2 - Search Data Base
                //3 - Add Recipe from File to database
                //4 - Add new Recipe via GUI
                //0 - Exit

            } while(userChoice != "0");

            dbm.close();
            scanner.close();

        } catch(SQLException sqle) {
            System.out.println("SQL Exception!");
            sqle.printStackTrace();
        } //End of Try/catch


    } //End of main
} //End of RecipeCore
