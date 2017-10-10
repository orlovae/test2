package com.test.alex.test.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by alex on 14.08.17.
 */

public class Event implements Parcelable, IModel {
    private Date startTime;
    private Date endTime;
    private String name;

    public Event(Date startTime, Date endTime, String name) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
    }

    public Event(Parcel in) {
        long[] date = new long[2];
        in.readLongArray(date);
        startTime = new Date(date[0]);
        endTime = new Date(date[1]);
        name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLongArray(new long[] {startTime.getTime(), endTime.getTime()});
        parcel.writeString(name);
    }

    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {

        @Override
        public Event createFromParcel(Parcel parcel) {
            return new Event(parcel);
        }

        @Override
        public Event[] newArray(int i) {
            return new Event[i];
        }
    };

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public Date getEndTime() {
        return endTime;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getFromPlace() {
        return null;
    }

    @Override
    public String getToPlace() {
        return null;
    }

    @Override
    public Date getEstimalTime() {
        return null;
    }

    @Override
    public void setFromPlace(String fromPlace) {

    }

    @Override
    public void setToPlace(String toPlace) {

    }

    @Override
    public void setEstimalTime(Date estimalTime) {

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


}
