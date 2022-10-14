package csc8011;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MuseumIO {

    private Scanner sc=new Scanner(System.in); // Initialized the Scanner object
    boolean showMenuFlag =true; // boolean flag, by default set to true. To show menu every time to user.
    private final String option_1= "1 : Enter the name of the museum";
    private final String option_2= "2: Read in information on the exhibits from a .csv file in the current directory called exhibits.csv. See below for a specification of this file.";
    private final String option_3= "3: Print a summary of the museum name followed by a list of all exhibits, their value and the year acquired.";
    private final String option_4= "4: Print statistics on exhibits, showing the full details of exhibit with the highest value, first exhibit acquired and average value of exhibits in the museum's collection, to the console";
    private final String option_5= "5: Exit the menu options";
    ArrayList < Exhibit > exhibits = new ArrayList < Exhibit > ( ); // Initialized the empty list of Exhibit type
    ArrayList < String > exhibitIds = new ArrayList < String > ( ); // Initialized the empty list of String type
    ArrayList < String > exhibitDescriptions = new ArrayList < String > ( ); // Initialized the empty list of String type
    ArrayList < Integer > exhibitYears = new ArrayList < Integer > ( ); // Initialized the empty list of Integer type
    ArrayList < Double > exhibitValues = new ArrayList < Double > ( );// Initialized the empty list of Double type


    /*
    * Below methods are the getter methods for all the variable of menu option's
    */

    public String getOption_1 ( ) {
        return option_1;
    }

    public String getOption_2 ( ) {
        return option_2;
    }

    public String getOption_3 ( ) {
        return option_3;
    }

    public String getOption_4 ( ) {
        return option_4;
    }
    public String getOption_5 ( ) {
        return option_5;
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
        System.out.println (getOption_5 () +"\n"); // after option 5 point the cursor to the next line
    }

    /**
     * Method which respond to user input for menu option_1 and
     * check entered museum is correct or not. If not notify the user
     * by an appropriate message.
     */
    public void museumNameInput(){
        String museumName = sc.nextLine ();
        if(museumName.equalsIgnoreCase ( "Vintage computer museum" )){
            Museum museum = new Museum ( museumName );
            System.out.println ("Museum name: " + museum.getMuseumName () );
        }else{
            System.out.println ("Entered museum name doesn't match the data." + "\n" + "Please Try again!" );
        }
    }

    public static void main(String[] args) {

        MuseumIO museumIO =new MuseumIO(); // creates an object MuseumIO class.

        // Entry point : will check is @showMenuFlag is true, If yes, continue the loop.
        while ( museumIO.showMenuFlag ){
            museumIO.showMenu ();

            try{
                int menuOption = museumIO.sc.nextInt (); // User input option

                switch (menuOption) {
                    case 1:
                        museumIO.museumNameInput ();
                        break;
                    case 2:
                        museumIO.readCsv ();
                        break;
                    case 3:
                        Exhibit exhibit = new Exhibit ( museumIO.exhibits );
                        exhibit.getExhibitsSummary ();
                        break;
                    case 4:
                        Museum museum =  new Museum ( museumIO.exhibitIds,museumIO.exhibitDescriptions,museumIO.exhibitYears, museumIO.exhibitValues);
                        museum.showStatistic ();
                        break;
                    case 5:
                        museumIO.showMenuFlag =false; // will set the flag to false and exit the code.
                        System.out.println("Thank You");
                        break;
                }
            }catch ( InputMismatchException inputMismatchException ){
                System.out.println ("Please Try again!" );
            }

        }


    }
}
