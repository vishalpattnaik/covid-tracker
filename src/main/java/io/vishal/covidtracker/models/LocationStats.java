package io.vishal.covidtracker.models;

public class LocationStats {

    private String date;
    private String prevDate;
    private String prevPrevDate;
    private String country;
    private int latestTotalCases;
    private int latestPrevDayCases;
    private int latestPrevPrevDayCases;

    public int getLatestPrevDayCases() {
        return latestPrevDayCases;
    }

    public void setLatestPrevDayCases(int latestPrevDayCases) {
        this.latestPrevDayCases = latestPrevDayCases;
    }

    public int getLatestPrevPrevDayCases() {
        return latestPrevPrevDayCases;
    }

    public void setLatestPrevPrevDayCases(int latestPrevPrevDayCases) {
        this.latestPrevPrevDayCases = latestPrevPrevDayCases;
    }

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

    @Override
    public String toString() {
        return "LocationStats{" +
                "date='" + date + '\'' +
                ", prevDate='" + prevDate + '\'' +
                ", prevPrevDate='" + prevPrevDate + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                ", latestPrevDayCases=" + latestPrevDayCases +
                ", latestPrevPrevDayCases=" + latestPrevPrevDayCases +
                '}';
    }
}
