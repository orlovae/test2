package com.test.alex.test.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by alex on 14.08.17.
 */

public class Event implements Parcelable {
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
