package csc8011;

import java.util.ArrayList;

public class Museum {

    private String museumName; // Initialized the variable museumName.
    private ArrayList<String> exhibitIds= new ArrayList<String>(); // Initialized the variable list of exhibitIds.
    private ArrayList<String> exhibitDescriptions = new ArrayList<String>(); // Initialized the variable list of exhibitDescriptions.
    private ArrayList<Double> exhibitValues= new ArrayList<Double>(); // Initialized the variable list of  exhibitValues.
    private ArrayList<Integer> exhibitYears= new ArrayList<Integer>(); // Initialized the variable list of  exhibitYears.


    /**
     * @param museumName use to create an object if museum name is passed
     */
    public Museum(String museumName){
        this.setMuseumName(museumName);
    }

    /**
     * parameterised constructor which accept the below params
     * @param exhibitIds list of exhibitsID
     * @param exhibitDescriptions list of exhibitDescriptions
     * @param exhibitYears list of exhibitYears
     * @param exhibitValues list of exhibitValues
     */
    public Museum(ArrayList<String> exhibitIds, ArrayList<String> exhibitDescriptions,ArrayList<Integer> exhibitYears,ArrayList<Double> exhibitValues){
        this.setExhibitIds(exhibitIds);
        this.setExhibitDescriptions (exhibitDescriptions);
        this.setExhibitValues(exhibitValues);
        this.setExhibitYears(exhibitYears);
    }

    // Below are the getter and setter methods

    /**
     * @return  the list of the exhibits values.
     */
    public ArrayList<Double> getExhibitValues() {
        return exhibitValues;
    }

    /**
     * @param exhibitValues set the exhibits values.
     */
    public void setExhibitValues(ArrayList<Double> exhibitValues) {
        this.exhibitValues = exhibitValues;
    }

    public ArrayList<Integer> getExhibitYears() {
        return exhibitYears;
    }

    public void setExhibitYears(ArrayList<Integer> exhibitYears) {
        this.exhibitYears = exhibitYears;
    }

    public ArrayList<String> getExhibitIds() {
        return exhibitIds;
    }

    public void setExhibitIds(ArrayList<String> exhibitIds) {
        this.exhibitIds = exhibitIds;
    }

    public ArrayList<String> getExhibitDescriptions () {
        return exhibitDescriptions;
    }

    public void setExhibitDescriptions ( ArrayList<String> exhibitDescriptions ) {
        this.exhibitDescriptions = exhibitDescriptions;
    }

    public String getMuseumName() {
        return museumName;
    }

    public void setMuseumName(String museumName) {
        this.museumName = museumName;
    }

    /**
     * Print statistics on exhibits, showing the full details of exhibit with the highest value
     */
    public void getHighestValueOfTheExhibit(){
        // Create maxValue variable and initialize with 0
        double maxValue = 0;
        int i=0; // initialized an index
        String tmpDescription=""; // initialized a temp variable to store the description through index number
        String tmpExhibitId="";   // initialized a temp variable to store the exhibitId through index number

        // Check maximum element using for loop
        for ( Double exhibitValue : exhibitValues) {
            if (exhibitValue > maxValue){
                tmpDescription= getExhibitDescriptions ().get ( i );
                tmpExhibitId=getExhibitIds ().get ( i );
                maxValue = exhibitValue;
            }
            i++;
        }
        System.out.println("Highest value exhibit: "+tmpDescription+"("+tmpExhibitId+"),£" + maxValue);
    }

    /**
     * Print statistics on exhibits, showing the full details of exhibit with first exhibit acquired
     */
    public void getFirstExhibitAcquired(){
        // initialize the min to some maximum value
        Integer min = Integer.MAX_VALUE;

        int i=0; // Initialized a variable set to 0

        String tmpDescription=""; // Initialized an empty String variable.

        /* now we have to loop through every data in the year list and
        compare the min value found so far with current value*/
        for ( int exhibitYear : exhibitYears) {
            //check if the min value is greater than the current value
            if (min > exhibitYear){
                tmpDescription= getExhibitDescriptions ().get ( i ); // get and set the tmp variable value from the list of description
                min = exhibitYear; // set min value equals current value
            }
            i++; // increment i everytime
        }
        System.out.println("First exhibit acquired:"+ tmpDescription +" (acquired "+min+")");
    }

    /**
     * Print statistics on exhibits, showing the average value of exhibits in the museum's collection,
     */
    public void getAverageValueOfAllExhibits(){

        double totalSum=0, average; // initialized variables

        // loop through list of exhibits values and  find the total sum.
        for (Double exhibitValue : exhibitValues) {
            totalSum = totalSum + exhibitValue;
        }

        average = totalSum/exhibitValues.size (); // find the average by dividing the total sum by total exhibits values.

        System.out.println ("Average value of exhibits: £"+ average ); // print the average
    }

    /**
     * This is called to show the details about the statistic of the museum
     * where we call 3 different methods to gather the data and print them in console.
     */
    public void showStatistic(){

        //Print statistics on exhibits, showing the full details of exhibit with the highest value
        getHighestValueOfTheExhibit();

        //Print first exhibit acquired and average value of exhibits in the museum's collection
        getFirstExhibitAcquired();

        //Print average value of all exhibits.
        getAverageValueOfAllExhibits();
    }
}
