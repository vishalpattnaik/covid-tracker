package io.vishal.covidtracker.models;

public class LocationStats {

    private String date;
    private String prevDate;
    private String prevPrevDate;
    private String country;
    private int latestTotalCases;
    private int diffFromPreviousDay;

    public String getPrevDate() {
        return prevDate;
    }

    public void setPrevDate(String prevDate) {
        this.prevDate = prevDate;
    }

    public String getPrevPrevDate() {
        return prevPrevDate;
    }

    public void setPrevPrevDate(String prevPrevDate) {
        this.prevPrevDate = prevPrevDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestTotalCases() {
        return latestTotalCases;
    }

    public void setLatestTotalCases(int latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }

    public int getDiffFromPreviousDay() {
        return diffFromPreviousDay;
    }

    public void setDiffFromPreviousDay(int diffFromPreviousDay) {
        this.diffFromPreviousDay = diffFromPreviousDay;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "date='" + date + '\'' +
                ", prevDate='" + prevDate + '\'' +
                ", prevPrevDate='" + prevPrevDate + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                ", diffFromPreviousDay=" + diffFromPreviousDay +
                '}';
    }
}
