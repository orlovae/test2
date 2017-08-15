package com.test.alex.test.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by alex on 14.08.17.
 */

public class Move implements Parcelable {
    private String fromPlace;
    private String toPlace;
    private Date estimaTime;

    public Move(String fromPlace, String toPlace, Date estimaTime) {
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.estimaTime = estimaTime;
    }

    public Move(Parcel in) {
        String[] date = new String[2];
        in.readStringArray(date);
        fromPlace = date[0];
        toPlace = date[1];
        estimaTime = new Date(in.readLong());
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public Date getEstimaTime() {
        return estimaTime;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public void setEstimaTime(Date estimaTime) {
        this.estimaTime = estimaTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[] {fromPlace, toPlace});
        parcel.writeLong(estimaTime.getTime());
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
