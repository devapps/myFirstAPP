package com.example.manojk.ors.Models;
import java.util.Date;

/**
 * Created by manojK on 07/11/2016.
 */
public class orsAvailableServicesSearch {
    String sLeaving, sDeparting, busType;
    Date dDate;

    public orsAvailableServicesSearch(String sLeaving, String sDeparting, String busType, Date dDate) {
        this.setsLeaving(sLeaving);
        this.setsDeparting(sDeparting);
        this.setBusType(busType);
        this.setdDate(dDate);
    }

    public String getsLeaving() {
        return sLeaving;
    }

    public void setsLeaving(String sLeaving) {
        this.sLeaving = sLeaving;
    }

    public String getsDeparting() {
        return sDeparting;
    }

    public void setsDeparting(String sDeparting) {
        this.sDeparting = sDeparting;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public Date getdDate() {
        return dDate;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }
}
