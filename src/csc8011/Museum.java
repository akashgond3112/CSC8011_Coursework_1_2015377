package csc8011;

import java.util.ArrayList;

public class Museum {

    private String museumName;
    private ArrayList<String> exhibitIds= new ArrayList<String>();
    private ArrayList<String> exhibitDescriptions = new ArrayList<String>();
    private ArrayList<Double> exhibitValues= new ArrayList<Double>();
    private ArrayList<Integer> exhibitYears= new ArrayList<Integer>();
    private ArrayList<Exhibit> exhibits = new ArrayList<Exhibit>();


    Museum(String museumName){
        this.setMuseumName(museumName);
    }

    Museum(ArrayList<String> exhibitIds, ArrayList<String> exhibitDescriptions,ArrayList<Integer> exhibitYears,ArrayList<Double> exhibitValues, ArrayList<Exhibit> exhibits){
        this.setExhibitIds(exhibitIds);
        this.setExhibitDescriptions (exhibitDescriptions);
        this.setExhibitValues(exhibitValues);
        this.setExhibitYears(exhibitYears);
        this.setExhibits ( exhibits );
    }

    public ArrayList<Double> getExhibitValues() {
        return exhibitValues;
    }

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

    public ArrayList<Exhibit> getExhibits() {
        return exhibits;
    }

    public void setExhibits(ArrayList<Exhibit> exhibits) {
        this.exhibits = exhibits;
    }

    public String getMuseumName() {
        return museumName;
    }

    public void setMuseumName(String museumName) {
        this.museumName = museumName;
    }

    /**
     *
     */
    public void getHighestValueOfTheExhibit(){
        // Create maxValue variable and initialize with 0
        double maxValue = 0;
        int i=0;
        String tmpDescription="";
        String tmpExhibitId="";

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
     *
     */
    public void getFirstExhibitAcquired(){
        // initialize the min to some maximum value
        Integer min = Integer.MAX_VALUE;

        int i=0;

        String tmpDescription="";

        /* now we have to loop through every data in the year list and
        compare the min value found so far with current value*/
        for ( int exhibitYear : exhibitYears) {
            //check if the min value is greater than the current value
            if (min > exhibitYear){
                tmpDescription= getExhibitDescriptions ().get ( i ); // get and set the tmp variable value from the list of description
                min = exhibitYear; // set min value equals current value
            }
            i++;
        }

        System.out.println("First exhibit acquired:"+ tmpDescription +" (acquired "+min+")");
    }

    /**
     *
     */
    public void getAverageValueOfAllExhibits(){

        double totalSum=0, average;

        for(int z=0;z< exhibitValues.size (); z++){
            totalSum = totalSum+exhibitValues.get ( z );
        }

        average = totalSum/exhibitValues.size ();

        System.out.println ("Average value of exhibits: £"+ average );
    }
}
