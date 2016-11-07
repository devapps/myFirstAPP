package com.example.manojk.ors.Models;

import java.util.Date;

/**
 * Created by manojK on 07/11/2016.
 */
public class orsAvailableServices {
    int trip_srno, ID, onlineSeats, rKMS, rFare, DepotID, ReservationCharges, rTripID, TripID, totalSeats, availableSeats,closeTime;
    String busType, tripCode, Leaving, Departing, Via, rDesc, boarding, plateform, dropping, TripRoute,depotShortName;
    Date jTime1;

    public orsAvailableServices(int trip_srno, int ID, int onlineSeats, int rKMS, int rFare, int depotID, int reservationCharges, int rTripID, int tripID, int totalSeats, int availableSeats, int closeTime, String busType, String tripCode, String leaving, String departing, String via, String rDesc, String boarding, String plateform, String dropping, String tripRoute, String depotShortName, Date jTime1) {
        this.trip_srno = trip_srno;
        this.ID = ID;
        this.onlineSeats = onlineSeats;
        this.rKMS = rKMS;
        this.rFare = rFare;
        DepotID = depotID;
        ReservationCharges = reservationCharges;
        this.rTripID = rTripID;
        TripID = tripID;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.closeTime = closeTime;
        this.busType = busType;
        this.tripCode = tripCode;
        this.Leaving = leaving;
        this.Departing = departing;
        this.Via = via;
        this.rDesc = rDesc;
        this.boarding = boarding;
        this.plateform = plateform;
        this.dropping = dropping;
        TripRoute = tripRoute;
        this.depotShortName = depotShortName;
        this.jTime1 = jTime1;
    }

    public int getTrip_srno() {
        return trip_srno;
    }

    public void setTrip_srno(int trip_srno) {
        this.trip_srno = trip_srno;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getOnlineSeats() {
        return onlineSeats;
    }

    public void setOnlineSeats(int onlineSeats) {
        this.onlineSeats = onlineSeats;
    }

    public int getrKMS() {
        return rKMS;
    }

    public void setrKMS(int rKMS) {
        this.rKMS = rKMS;
    }

    public int getrFare() {
        return rFare;
    }

    public void setrFare(int rFare) {
        this.rFare = rFare;
    }

    public int getDepotID() {
        return DepotID;
    }

    public void setDepotID(int depotID) {
        DepotID = depotID;
    }

    public int getReservationCharges() {
        return ReservationCharges;
    }

    public void setReservationCharges(int reservationCharges) {
        ReservationCharges = reservationCharges;
    }

    public int getrTripID() {
        return rTripID;
    }

    public void setrTripID(int rTripID) {
        this.rTripID = rTripID;
    }

    public int getTripID() {
        return TripID;
    }

    public void setTripID(int tripID) {
        TripID = tripID;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getTripCode() {
        return tripCode;
    }

    public void setTripCode(String tripCode) {
        this.tripCode = tripCode;
    }

    public String getLeaving() {
        return Leaving;
    }

    public void setLeaving(String leaving) {
        Leaving = leaving;
    }

    public String getDeparting() {
        return Departing;
    }

    public void setDeparting(String departing) {
        Departing = departing;
    }

    public String getVia() {
        return Via;
    }

    public void setVia(String via) {
        Via = via;
    }

    public String getrDesc() {
        return rDesc;
    }

    public void setrDesc(String rDesc) {
        this.rDesc = rDesc;
    }

    public String getBoarding() {
        return boarding;
    }

    public void setBoarding(String boarding) {
        this.boarding = boarding;
    }

    public String getPlateform() {
        return plateform;
    }

    public void setPlateform(String plateform) {
        this.plateform = plateform;
    }

    public String getDropping() {
        return dropping;
    }

    public void setDropping(String dropping) {
        this.dropping = dropping;
    }

    public String getTripRoute() {
        return TripRoute;
    }

    public void setTripRoute(String tripRoute) {
        TripRoute = tripRoute;
    }

    public String getDepotShortName() {
        return depotShortName;
    }

    public void setDepotShortName(String depotShortName) {
        this.depotShortName = depotShortName;
    }

    public Date getjTime1() {
        return jTime1;
    }

    public void setjTime1(Date jTime1) {
        this.jTime1 = jTime1;
    }
}
