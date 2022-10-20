package csc8011;

import java.util.ArrayList;

public class Museum {

    private String museumName; // Initialized the variable museumName.

    private ArrayList <Exhibit> exhibits = new ArrayList<Exhibit>();

    /**
     * default constructor
     */
    public Museum(){}

    /**
     * constructor
     * @param museumName use to create an object if museum name is passed
     */
    public Museum(String museumName){
        this.setMuseumName(museumName);
    }

    // Below are the getter and setter methods
    public String getMuseumName() {
        return museumName;
    }

    public void setMuseumName(String museumName) {
        this.museumName = museumName;
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
     * @param exhibit add to the list
     */
    public void addExhibitToList(Exhibit exhibit){
        this.exhibits.add(exhibit);
    }

    /**
     * This method is used to Print a summary of the museum name followed by a list of all exhibits,
     * their value and the year acquired to the console.
     */
    public void getExhibitsSummary(){

        if(!this.museumName.isEmpty() && exhibits.size()>0){
            System.out.println("Museum name : "+this.museumName); // call the getMuseumName method to get the name of the museum
        /*We will loop through each Exhibit object from the list and print the data
                by calling the getter method from the Exhibit Class*/
            for ( Exhibit exhibit : this.exhibits ) {
                // We will loop through each Exhibit object and call the getter method to get the details and print them one by one.
                System.out.println ( "Exhibit Id: " + exhibit.getExhibitId ( ) + " Description: " + exhibit.getDescription ( ) + " Year acquired: "
                        + exhibit.getYearAcquired ( ) + " Value: " + exhibit.getValue ( ) );
            }
        }else{
            System.out.println("Please select the menu option 1 and 2, before running the summary option!");
        }

    }

    /**
     * return exhibit with the highest value out of all the exhibits
     */
    public Exhibit getHighestValueOfTheExhibit(){
        // in order to compare the value within the exhibits lists, get the first exhibits from list
        Exhibit tmpExhibit = exhibits.get(0);

        // Check maximum element using for loop
        for ( Exhibit exhibit : exhibits) {
            if (exhibit.getValue() > tmpExhibit.getValue()){
                tmpExhibit= exhibit;
            }
        }
        return tmpExhibit;
    }

    /**
     * return the exhibit which was first acquired out of all the exhibits
     */
    public Exhibit getFirstExhibitAcquired(){
        // initialize the min to some maximum value
        int min = Integer.MAX_VALUE;
        Exhibit tmpExhibit = null; // initialize an empty exhibit.

        /* now we have to loop through every data in the exhibits list and
        compare the min value found so far with current value*/
        for ( Exhibit exhibit : exhibits) {
            //check if the min value is greater than the current value
            if (min > exhibit.getYearAcquired()){
                min = exhibit.getYearAcquired(); // set min value equals current value
                tmpExhibit= exhibit;
            }
        }
        return tmpExhibit;
    }

    /**
     * return the average value of exhibits in the museum's collection,
     */
    public Double getAverageValueOfAllExhibits(){

        double totalSum=0; // initialized variables

        // loop through list of exhibits values and  find the total sum.
//        for (Double exhibitValue : exhibitValues) {
        for (Exhibit exhibit : exhibits) {
            totalSum = totalSum + exhibit.getValue();
        }
        return totalSum/exhibits.size (); // find the average by dividing the total sum by total exhibits size and return.
    }


}
