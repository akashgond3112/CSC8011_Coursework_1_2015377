package csc8011;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MuseumIO {

    String museumName;

    public MuseumIO ( String museumName ) {
        this.museumName = museumName;
    }

    public void readCsv ( ) {
        if ( museumName.isEmpty ( ) || museumName == null ) {
            System.out.println ( "Please provide the museum name!" );
        } else {
            Museum museum = new Museum ( museumName );

            System.out.println ( "Museum name: " + museum.getMuseumName ( ) );
            try {
                Scanner readCsv = new Scanner ( new File ( "src/data/exhibits.csv" ) );
                ArrayList < Exhibit > exhibits = new ArrayList < Exhibit > ( );
                ArrayList < String > exhibitIds = new ArrayList < String > ( );
                ArrayList < String > exhibitDescriptions = new ArrayList < String > ( );
                ArrayList < Integer > exhibitYears = new ArrayList < Integer > ( );
                ArrayList < Double > exhibitValues = new ArrayList < Double > ( );

                Exhibit exhibitObject = new Exhibit ( );

                while ( readCsv.hasNextLine ( ) ) {
                    String line = readCsv.nextLine ( );
                    String[] lineArray = line.split ( "," ); // split the sentences using String split inbuilt method.

                    // 1st approach to create an Exhibit object to store values.
                    // results.add(new Exhibit(lineArray[0], lineArray[1], Integer.parseInt(lineArray[2]), Double.parseDouble(lineArray[3])));

                    // 2nd approach to create an Exhibit object to store values using getter and setter method.
                    exhibitObject.setExhibitId ( lineArray[ 0 ] ); // To se the Exhibit id.
                    exhibitIds.add ( lineArray[ 0 ]);

                    exhibitObject.setDescription ( lineArray[ 1 ] ); // To set the description of the museum.
                    exhibitDescriptions.add (  lineArray[ 1 ]);

                    exhibitObject.setYearAcquired ( Integer.parseInt ( lineArray[ 2 ] ) ); // To set the year of the museum.
                    exhibitYears.add (Integer.parseInt ( lineArray[ 2 ] )  );

                    exhibitObject.setValue ( Double.parseDouble ( lineArray[ 3 ] ) ); // To set the value of the museum.
                    exhibitValues.add ( Double.parseDouble ( lineArray[ 3 ] ) );

                    // Add the object to the list.
                    exhibits.add ( exhibitObject );

                }

                Museum museum1=  new Museum ( exhibitIds,exhibitDescriptions,exhibitYears, exhibitValues,exhibits);

                /*We will loop through each Exhibit object from the list and print the data
                by calling the getter method from the Exhibit Class*/
                for ( Exhibit exhibit : museum.getExhibits ( ) ) {
                    System.out.println ( "Exhibit Id: " + exhibit.getExhibitId ( ) + " Description: " + exhibit.getDescription ( ) + " Year acquired: "
                            + exhibit.getYearAcquired ( ) + " Value: " + exhibit.getValue ( ) );
                }

                //Print statistics on exhibits, showing the full details of exhibit with the highest value
                museum1.getHighestValueOfTheExhibit();

                //Print first exhibit acquired and average value of exhibits in the museum's collection
                museum1.getFirstExhibitAcquired();

                //Print average value of all exhibits.
                museum1.getAverageValueOfAllExhibits();

                readCsv.close ( ); // closing the Scanner class

            } catch ( FileNotFoundException fileNotFoundException ) {
                System.out.println ( fileNotFoundException.getMessage ( ) );
            }
        }
    }

    /**
     * @param exhibitId
     * @return This method will return list of a exhibitsId's.
     */
    public ArrayList < String > creatListOfExhibitIds ( String exhibitId ) {
        if (exhibitId==null) return null;
        ArrayList < String > exhibitIds = new ArrayList < String > ( );
        exhibitIds.add ( exhibitId );
        return exhibitIds;
    }

    /**
     * @param description
     * @return
     */
    public ArrayList < String > creatListOfExhibitDescriptions ( String description ) {
        if (description==null) return null;

        ArrayList < String > exhibitDescriptions = new ArrayList < String > ( );
        exhibitDescriptions.add ( description );
        return exhibitDescriptions;
    }

    /**
     * @param exhibitYear
     * @return
     */
    public ArrayList < Integer > creatListOfExhibitYears ( Integer exhibitYear ) {
        if (exhibitYear==null) return null;

        ArrayList < Integer > exhibitYears = new ArrayList < Integer > ( );
        exhibitYears.add ( exhibitYear );
        return exhibitYears;
    }

    /**
     * @param exhibitValue
     * @return
     */
    public ArrayList < Double > creatListOfExhibitValues ( Double exhibitValue ) {
        if (exhibitValue==null) return null;

        ArrayList < Double > exhibitValues = new ArrayList < Double > ( );
        exhibitValues.add ( exhibitValue );
        return exhibitValues;
    }

}
