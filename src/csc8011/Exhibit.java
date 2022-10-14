package csc8011;

import java.util.ArrayList;

public class Exhibit {
    String exhibitId;
    String description;
    int yearAcquired;
    double value;

    public ArrayList<Exhibit> getExhibits() {
        return exhibits;
    }

    public void setExhibits(ArrayList<Exhibit> exhibits) {
        this.exhibits = exhibits;
    }

    private ArrayList <Exhibit> exhibits = new ArrayList<Exhibit>();


    public Exhibit(ArrayList <Exhibit> exhibits) {
        setExhibits ( exhibits );
    }

    Exhibit(String exhibitId,String description,int yearAcquired, double value){
        setExhibitId ( exhibitId );
        setDescription ( description );
        setYearAcquired ( yearAcquired );
        setValue ( value );
    }



    public String getExhibitId() {
        return exhibitId;
    }

    public void setExhibitId(String exhibitId) {
        this.exhibitId = exhibitId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYearAcquired() {
        return yearAcquired;
    }

    public void setYearAcquired(int yearAcquired) {
        this.yearAcquired = yearAcquired;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void getExhibitsSummary(){
        /*We will loop through each Exhibit object from the list and print the data
                by calling the getter method from the Exhibit Class*/
        for ( Exhibit exhibit : exhibits ) {
            System.out.println ( "Exhibit Id: " + exhibit.getExhibitId ( ) + " Description: " + exhibit.getDescription ( ) + " Year acquired: "
                    + exhibit.getYearAcquired ( ) + " Value: " + exhibit.getValue ( ) );
        }
    }
}
