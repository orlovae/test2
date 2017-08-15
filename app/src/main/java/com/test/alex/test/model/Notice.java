package com.test.alex.test.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by alex on 14.08.17.
 */

public class Notice implements Parcelable {
    private Date flightDate;
    private String gate;

    public Notice(Date flightDate, String gate) {
        this.flightDate = flightDate;
        this.gate = gate;
    }

    public Notice(Parcel in) {
        flightDate = new Date(in.readLong());
        gate = in.readString();
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(flightDate.getTime());
        parcel.writeString(gate);
    }

    public static final Parcelable.Creator<Notice> CREATOR = new Parcelable.Creator<Notice>() {

        @Override
        public Notice createFromParcel(Parcel parcel) {
            return new Notice(parcel);
        }

        @Override
        public Notice[] newArray(int i) {
            return new Notice[i];
        }
    };
}
