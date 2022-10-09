package csc8011;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MuseumIO {

    String museumName;

    public MuseumIO(String museumName){
        this.museumName =museumName;
    }

    public void readCsv(){
        if(museumName.isEmpty() || museumName==null){
            System.out.println("Please provide the museum name!");
        }else{
            try{
                Scanner readCsv =  new Scanner(new File("src/data/exhibits.csv"));
//                readCsv.useDelimiter(","); // split each string with comma seperated
                ArrayList< Exhibit > results = new ArrayList < Exhibit > ();
                while(readCsv.hasNextLine()){
//                    System.out.println(readCsv.next());
                    String line = readCsv.nextLine();
                    String[] lineArray = line.split(",");
                    results.add(new Exhibit(lineArray[0], lineArray[1], Integer.parseInt(lineArray[2]), Double.parseDouble(lineArray[3])));
                }

                for(Exhibit exhibit : results){
                    System.out.println("Exhibit Id: "+exhibit.exhibitId+" Description: "+exhibit.description+" Year acquired: "
                            +exhibit.yearAcquired+" Value: "+exhibit.value);
                }

                readCsv.close(); // closing the Scanner class

            }catch (FileNotFoundException fileNotFoundException){
                System.out.println(fileNotFoundException.getMessage());
            }
        }
        System.out.println("I am in :" + museumName);
    }

}
