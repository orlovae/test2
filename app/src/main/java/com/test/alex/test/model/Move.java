package com.test.alex.test.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by alex on 14.08.17.
 */

public class Move implements Parcelable, IModel {
    private String fromPlace;
    private String toPlace;
    private Date estimalTime;

    public Move(String fromPlace, String toPlace, Date estimalTime) {
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.estimalTime = estimalTime;
    }

    public Move(Parcel in) {
        String[] date = new String[2];
        in.readStringArray(date);
        fromPlace = date[0];
        toPlace = date[1];
        estimalTime = new Date(in.readLong());
    }

    @Override
    public Date getStartTime() {
        return null;
    }

    @Override
    public Date getEndTime() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setStartTime(Date startTime) {

    }

    @Override
    public void setEndTime(Date endTime) {

    }

    @Override
    public void setName(String name) {

    }

    public String getFromPlace() {
        return fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public Date getEstimalTime() {
        return estimalTime;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public void setEstimalTime(Date estimalTime) {
        this.estimalTime = estimalTime;
    }

    @Override
    public Date getFlightDate() {
        return null;
    }

    @Override
    public String getGate() {
        return null;
    }

    @Override
    public void setFlightDate(Date flightDate) {

    }

    @Override
    public void setGate(String gate) {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[] {fromPlace, toPlace});
        parcel.writeLong(estimalTime.getTime());
    }

    public static final Parcelable.Creator<Move> CREATOR = new Parcelable.Creator<Move>() {

        @Override
        public Move createFromParcel(Parcel parcel) {
            return new Move(parcel);
        }

        @Override
        public Move[] newArray(int i) {
            return new Move[i];
        }
    };
}
