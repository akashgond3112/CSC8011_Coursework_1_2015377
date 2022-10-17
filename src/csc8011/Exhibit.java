package csc8011;

import java.util.ArrayList;

public class Exhibit {

    // Initialized the private variable , which will be only accessible using getter and setter method
    private String exhibitId;
    private String description;
    private int yearAcquired;
    private double value;
    private ArrayList <Exhibit> exhibits = new ArrayList<Exhibit>();


    /**
     * @param exhibits
     * constructor which accept list of exhibits as a parameter.
     */
    Exhibit(ArrayList <Exhibit> exhibits) {
        setExhibits ( exhibits );
    }

    /**
     * @param exhibitId
     * @param description
     * @param yearAcquired
     * @param value
     * parameterised constructor which accept the above listed params.
     */
    Exhibit(String exhibitId,String description,int yearAcquired, double value){
        setExhibitId ( exhibitId );
        setDescription ( description );
        setYearAcquired ( yearAcquired );
        setValue ( value );
    }


    /**
     * Below are the getter which return the values.
     * @return  exhibitId
     */
    public String getExhibitId() {
        return exhibitId;
    }

    /**
     * Below are the Setter methods use to set the values
     * @param exhibitId  set the values.
     */
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

    /**
     * @return list of Exhibits object
     */
    public ArrayList<Exhibit> getExhibits() {
        return exhibits;
    }

    /**
     * @param exhibits used to set the variable.
     */
    public void setExhibits(ArrayList<Exhibit> exhibits) {
        this.exhibits = exhibits;
    }

    /**

     * @param museumName
     * This method is used to Print a summary of the museum name followed by a list of all exhibits,
     * their value and the year acquired to the console.
     */
    public void getExhibitsSummary(String museumName){

        System.out.println("Museum name : "+museumName); // call the getMuseumName method to get the name of the museum
        /*We will loop through each Exhibit object from the list and print the data
                by calling the getter method from the Exhibit Class*/
        for ( Exhibit exhibit : exhibits ) {
            // We will loop through each Exhibit object and call the getter method to get the details and print them one by one.
            System.out.println ( "Exhibit Id: " + exhibit.getExhibitId ( ) + " Description: " + exhibit.getDescription ( ) + " Year acquired: "
                    + exhibit.getYearAcquired ( ) + " Value: " + exhibit.getValue ( ) );
        }
    }
}
