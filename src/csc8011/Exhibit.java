package csc8011;

public class Exhibit {
    String exhibitId;
    String description;
    int yearAcquired;
    double value;

    Exhibit(String exhibitId,String description,int yearAcquired, double value){
        this.exhibitId=exhibitId;
        this.description=description;
        this.yearAcquired=yearAcquired;
        this.value=value;

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
}
