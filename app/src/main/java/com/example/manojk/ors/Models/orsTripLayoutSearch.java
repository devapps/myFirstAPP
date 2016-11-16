package com.example.manojk.ors.Models;

/**
 * Created by manojK on 16/11/2016.
 */
public class orsTripLayoutSearch {
    String TripID, BusType;

    public orsTripLayoutSearch(String tripID, String busType) {
        TripID = tripID;
        BusType = busType;
    }

    public String getTripID() {
        return TripID;
    }

    public void setTripID(String tripID) {
        TripID = tripID;
    }

    public String getBusType() {
        return BusType;
    }

    public void setBusType(String busType) {
        BusType = busType;
    }
}
