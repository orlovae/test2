package com.test.alex.test.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import static com.test.alex.test.Constant.FLIGHT_DATE;
import static com.test.alex.test.Constant.FULL_FORMAT;
import static com.test.alex.test.Constant.GATE;

/**
 * Created by alex on 14.08.17.
 */

public class Notice implements IModel {
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

    @Override
    public String getInfoFromModel() {
        StringBuffer buffer = new StringBuffer(this.getClass().getSimpleName());
        buffer.append("\n ");
        buffer.append(FLIGHT_DATE);
        buffer.append(": ");
        buffer.append(FULL_FORMAT.format(flightDate));
        buffer.append("\n ");
        buffer.append(GATE);
        buffer.append(" - ");
        buffer.append(gate);
        return buffer.toString();
    }
}
