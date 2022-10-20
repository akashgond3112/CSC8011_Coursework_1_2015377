package csc8011;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MuseumIO {
    static boolean showMenuFlag =true; // static boolean flag, by default set to true. To show menu every time to user.
    static Museum museum = new Museum(); // Initialize a static variable for museum name .

    /*
    * Below methods are the getter methods for all the variable of menu option's
    */
    public static String getOption_1 ( ) {
        return "1 : Enter the name of the museum";
    }

    public static String getOption_2 ( ) {
        return "2: Read in information on the exhibits from a .csv file in the current directory called exhibits.csv. " +
                "See below for a specification of this file.";
    }

    public static String getOption_3 ( ) {
        return "3: Print a summary of the museum name followed by a list of all exhibits, their value and the year acquired.";
    }

    public static String getOption_4 ( ) {
        return "4: Print statistics on exhibits, showing the full details of exhibit with the highest value, " +
                "first exhibit acquired and average value of exhibits in the museum's collection, to the console";
    }
    public static String getOption_5 ( ) {
        return "5: Exit the menu options";
    }

    /**
     * In this method we are using the Scanner class , in order to read the csv file.
     * and looping through each row from the csv file and creating an exhibit object
     * and adding it to the museum exhibits list
     */
    public static void readCsv ( ) {
        try {
            Scanner readCsv = new Scanner ( new File ( "src/data/exhibits.csv" ) );
            readCsv.nextLine ( ); //always skip first line
            while ( readCsv.hasNextLine ( ) ) {
                String line = readCsv.nextLine ( );
                String[] lineArray = line.split ( "," ); // split the sentences using String split inbuilt method.

                // adding the Exhibit object to the list of the exhibits.
                museum.addExhibitToList(new Exhibit(lineArray[0], lineArray[1], Integer.parseInt(lineArray[2]), Double.parseDouble(lineArray[3])));
            }
            //checking if the loaded csv include at least 1 row
            if(museum.getExhibits().size()>0){
                System.out.println("Csv data is loaded successfully!");
            }else {
                System.out.println("Something went wrong while loading the CSV, Please check your CSV file!");
            }
            readCsv.close ( ); // closing the Scanner class

        } catch ( FileNotFoundException fileNotFoundException ) {
            System.out.println ( fileNotFoundException.getMessage ( ) ); // catching the exception .
        }
    }

    /**
     * This method behaviour is to show the list of the menu option available.
     */
    public static void showMenu(){
        System.out.println ("Menu : " );
        System.out.println ("Please select any menu option from the below list" );
        System.out.println (getOption_1 () );
        System.out.println (getOption_2 () );
        System.out.println (getOption_3 () );
        System.out.println (getOption_4 () );
        System.out.println (getOption_5 () ); // after option 5 point the cursor to the next line
    }

    /**
     * Method which respond to user input for menu option_1 and
     * check entered museum is empty or not and notify the user
     * by an appropriate message.
     */
    public static void museumNameInput(){
        Scanner sc=new Scanner(System.in); // Created an object for scanner class.
        System.out.println("Please enter the museum name below and press enter! ");
        String museumName = sc.nextLine (); // take the input from the user as String
        // check if entered museum name is not empty and is not blank
        if(museumName.isBlank() && museumName.isEmpty()) {
            System.out.println("Entered museum name cannot be empty." + "\n" + "Please Try again!");
        }else{
            museum.setMuseumName(museumName);
            if(!museum.getMuseumName().isEmpty()) System.out.println("Museum name : "+museum.getMuseumName()+ " was added successfully!");
        }
    }

    /**
     * A static method which call a method from the Museum class
     * to print the museum name and exhibits summary details
     */
    public static void printMuseumSummary(){
        museum.getExhibitsSummary();
    }

    /**
     * This is called to show the details about the statistic of the museum
     * where we call 3 different methods to gather the data and print them in console.
     */
    public static void showStatistic(){

        // Check if user has opted for option 2 or not for read csv
        //if not show user a message
        if(museum.getExhibits().size()>0){

            System.out.println("The statistics on highest value, first exhibit acquired and average value of exhibits:");

            Exhibit exhibit; // Initialized Museum ;

            //Print statistics on exhibits, showing the full details of exhibit with the highest value
            exhibit= museum.getHighestValueOfTheExhibit();
            System.out.println("Highest value exhibit: "+exhibit.getDescription()+"("+exhibit.getExhibitId()+"),£" + exhibit.getValue());

            //Print first exhibit acquired and average value of exhibits in the museum's collection
            exhibit = museum.getFirstExhibitAcquired();
            System.out.println("First exhibit acquired:"+ exhibit.getDescription() +" (acquired "+exhibit.getYearAcquired()+")");

            //Print average value of all exhibits.
            double average = museum.getAverageValueOfAllExhibits();
            System.out.println ("Average value of exhibits: £"+ average ); // print the average
        }else{
            System.out.println("Kindly choose the option 2 to before reading the statistic!");
        }
    }

    public static void main(String[] args) {
        // Entry point : will check is @showMenuFlag is true, If yes, continue the loop.
        while (showMenuFlag ){
            showMenu ();

            try{
                Scanner sc=new Scanner(System.in); // Created an object for scanner class.
                int menuOption = sc.nextInt (); // User input option as int
                Museum museum; // Initialized Museum class

                switch (menuOption) {
                    case 1:
                        museumNameInput ();
                        break;
                    case 2:
                        readCsv ();
                        break;
                    case 3:
                        printMuseumSummary();
                        break;
                    case 4:
                        showStatistic();
                        break;
                    case 5:
                        showMenuFlag =false; // will set the flag to false and exit the code.
                        System.out.println("Thank You");
                        break;
                }
            }catch ( InputMismatchException inputMismatchException ){ // Handling the input mismatch exception
                System.out.println ("Please Try again! by entering option as 1,2,3,4 or 5 to exit! " );
            }
        }
    }
}
