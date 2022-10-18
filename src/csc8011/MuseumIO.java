package csc8011;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MuseumIO {

     // Initialized the Scanner object
    boolean showMenuFlag =true; // boolean flag, by default set to true. To show menu every time to user.

    String museumName; // Initialize a variable for museum name .
    ArrayList < Exhibit > exhibits = new ArrayList < Exhibit > ( ); // Initialized the empty list of Exhibit type
    ArrayList < String > exhibitIds = new ArrayList < String > ( ); // Initialized the empty list of String type
    ArrayList < String > exhibitDescriptions = new ArrayList < String > ( ); // Initialized the empty list of String type
    ArrayList < Integer > exhibitYears = new ArrayList < Integer > ( ); // Initialized the empty list of Integer type
    ArrayList < Double > exhibitValues = new ArrayList < Double > ( );// Initialized the empty list of Double type


    /*
    * Below methods are the getter methods for all the variable of menu option's
    */

    public String getOption_1 ( ) {
        return "1 : Enter the name of the museum";
    }

    public String getOption_2 ( ) {
        return "2: Read in information on the exhibits from a .csv file in the current directory called exhibits.csv. " +
                "See below for a specification of this file.";
    }

    public String getOption_3 ( ) {
        return "3: Print a summary of the museum name followed by a list of all exhibits, their value and the year acquired.";
    }

    public String getOption_4 ( ) {
        return "4: Print statistics on exhibits, showing the full details of exhibit with the highest value, " +
                "first exhibit acquired and average value of exhibits in the museum's collection, to the console";
    }
    public String getOption_5 ( ) {
        return "5: Exit the menu options";
    }

    /**
     * In this method we are using the Scanner class , in order to read the csv file.
     * and looping through each row from the csv file and storing the data as an object
     * and list of data.
     */
    public void readCsv ( ) {
        try {
            Scanner readCsv = new Scanner ( new File ( "src/data/exhibits.csv" ) );
            while ( readCsv.hasNextLine ( ) ) {
                String line = readCsv.nextLine ( );
                String[] lineArray = line.split ( "," ); // split the sentences using String split inbuilt method.

                // adding the Exhibit object to the list of the exhibits.
                exhibits.add(new Exhibit(lineArray[0], lineArray[1], Integer.parseInt(lineArray[2]), Double.parseDouble(lineArray[3])));

                // creating a list of all the exhibit Id's
                exhibitIds.add ( lineArray[ 0 ]);

                // creating a list of all the exhibits description
                exhibitDescriptions.add (  lineArray[ 1 ]);

                // creating a list of all the exhibit Years
                exhibitYears.add (Integer.parseInt ( lineArray[ 2 ] )  );

                // creating a list of all the exhibits Values
                exhibitValues.add ( Double.parseDouble ( lineArray[ 3 ] ) );
            }

            readCsv.close ( ); // closing the Scanner class

        } catch ( FileNotFoundException fileNotFoundException ) {
            System.out.println ( fileNotFoundException.getMessage ( ) ); // catching the exception .
        }
    }

    /**
     * This method behaviour is to show the list of the menu option available.
     */
    public void showMenu(){
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
    public void museumNameInput(){
        Scanner sc=new Scanner(System.in); // Created an object for scanner class.
        System.out.println("Please enter the museum name below and press enter! ");
        museumName = sc.nextLine (); // take the input from the user as String
        // check if entered museum name is not empty and is not blank
        if(museumName.isBlank() && museumName.isEmpty()) {
            System.out.println("Entered museum name cannot be empty." + "\n" + "Please Try again!");
        }
    }

    public static void main(String[] args) {

        MuseumIO museumIO =new MuseumIO(); // creates an object MuseumIO class.

        // Entry point : will check is @showMenuFlag is true, If yes, continue the loop.
        while ( museumIO.showMenuFlag ){
            museumIO.showMenu ();

            try{
                Scanner sc=new Scanner(System.in); // Created an object for scanner class.
                int menuOption = sc.nextInt (); // User input option as int
                Museum museum; // Initialized Museum class

                switch (menuOption) {
                    case 1:
                        museumIO.museumNameInput ();
                        break;
                    case 2:
                        museumIO.readCsv (); // call the readCsv method to parse the csv and read the details
                        break;
                    case 3:
                        // Check if user has entered the museum name or not also
                        // the option 2 for read csv is selected by user or not
                        if(museumIO.museumName !=null && museumIO.exhibits.size()>0){
                            // create an object of exhibit class with the parameter as list of exhibits
                            Exhibit exhibit = new Exhibit ( museumIO.exhibits );
                            // create an object of museum class by passing the parameter as museum name.s
                            museum = new Museum(museumIO.museumName);
                            // call the method get summary by passing the parameter museum name from museum class
                            exhibit.getExhibitsSummary (museumIO.museumName);
                        }else{
                            System.out.println("Kindly choose the option 1 and 2 to before reading the summary!");
                        }

                        break;
                    case 4:
                        // Check if user has opted for option 2 or not for read csv
                        //if not show user a message
                        if(museumIO.exhibitIds.size()>0 && museumIO.exhibitDescriptions.size()>0 &&museumIO.exhibitYears.size()>0
                                && museumIO.exhibitValues.size()>0){
                        // Create an object of Museum class with all the column details of each exhibit
                            museum = new Museum(museumIO.exhibitIds, museumIO.exhibitDescriptions, museumIO.exhibitYears, museumIO.exhibitValues);
                            museum.showStatistic ();
                        }else{
                            System.out.println("Kindly choose the 2 to before reading the statistic!");
                        }

                        break;
                    case 5:
                        museumIO.showMenuFlag =false; // will set the flag to false and exit the code.
                        System.out.println("Thank You");
                        break;
                }
            }catch ( InputMismatchException inputMismatchException ){ // Handling the input mismatch exception
                System.out.println ("Please Try again! by entering option as 1,2,3,4 or 5 to exit! " );
            }

        }


    }
}
