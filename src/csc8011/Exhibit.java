package csc8011;

public class Exhibit {

    // Initialized the private variable , which will be only accessible using getter and setter method
    private String exhibitId;
    private String description;
    private int yearAcquired;
    private double value;

    /**
     * @param exhibitId museumID
     * @param description museumDescription
     * @param yearAcquired museum Year acquired
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
        if(exhibitId.contains(",")){
            throw new RuntimeException("ExhibitId should not contains (,). Please check your CSV file!");
        }else{
            this.exhibitId = exhibitId;
        }
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

}
