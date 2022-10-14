package csc8011;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MuseumIO {

    boolean showMenuFlag =true;
    private final String option_1= "1 : Enter the name of the museum";
    private final String option_2= "2: Read in information on the exhibits from a .csv file in the current directory called exhibits.csv. See below for a specification of this file.";
    private final String option_3= "3: Print a summary of the museum name followed by a list of all exhibits, their value and the year acquired.";
    private final String option_4= "4: Print statistics on exhibits, showing the full details of exhibit with the highest value, first exhibit acquired and average value of exhibits in the museum's collection, to the console";
    private final String option_5= "5: Exit the menu options";
    ArrayList < Exhibit > exhibits = new ArrayList < Exhibit > ( );
    ArrayList < String > exhibitIds = new ArrayList < String > ( );
    ArrayList < String > exhibitDescriptions = new ArrayList < String > ( );
    ArrayList < Integer > exhibitYears = new ArrayList < Integer > ( );
    ArrayList < Double > exhibitValues = new ArrayList < Double > ( );

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

    public void readCsv ( ) {
        try {
            Scanner readCsv = new Scanner ( new File ( "src/data/exhibits.csv" ) );
            while ( readCsv.hasNextLine ( ) ) {
                String line = readCsv.nextLine ( );
                String[] lineArray = line.split ( "," ); // split the sentences using String split inbuilt method.

                exhibits.add(new Exhibit(lineArray[0], lineArray[1], Integer.parseInt(lineArray[2]), Double.parseDouble(lineArray[3])));

                exhibitIds.add ( lineArray[ 0 ]);
                exhibitDescriptions.add (  lineArray[ 1 ]);
                exhibitYears.add (Integer.parseInt ( lineArray[ 2 ] )  );
                exhibitValues.add ( Double.parseDouble ( lineArray[ 3 ] ) );
            }

            readCsv.close ( ); // closing the Scanner class

        } catch ( FileNotFoundException fileNotFoundException ) {
            System.out.println ( fileNotFoundException.getMessage ( ) );
        }
    }

    public void showMenu(){
        System.out.println ("Menu : " );
        System.out.println ("Please select any menu option from the list" );
        System.out.println (getOption_1 () );
        System.out.println (getOption_2 () );
        System.out.println (getOption_3 () );
        System.out.println (getOption_4 () );
        System.out.println (getOption_5 () +"\n");
    }

    public void museumNameInput(Scanner sc){
        String museumName = sc.nextLine ();
        if(museumName.equalsIgnoreCase ( "Vintage computer museum" )){
            Museum museum = new Museum ( museumName );
            System.out.println ("Museum name: " + museum.getMuseumName () );
        }else{
            System.out.println ("Entered museum name doesn't match the data." + "\n" + "Please Try again!" );
        }
    }

    public static void main(String[] args) {

        MuseumIO museumIO =new MuseumIO();

        while ( museumIO.showMenuFlag ){
            museumIO.showMenu ();
            Scanner sc=new Scanner(System.in);
            try{
                int menuOption = sc.nextInt ();
                switch (menuOption) {
                    case 1:
                        museumIO.museumNameInput (sc);
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
                        museumIO.showMenuFlag =false;
                        System.out.println("Thank You");
                        break;
                }
            }catch ( InputMismatchException inputMismatchException ){
                System.out.println ("Please Try again!" );
            }

        }


    }
}
