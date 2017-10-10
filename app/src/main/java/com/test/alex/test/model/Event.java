package com.test.alex.test.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import static com.test.alex.test.Constant.END_TIME;
import static com.test.alex.test.Constant.FULL_FORMAT;
import static com.test.alex.test.Constant.NAME;
import static com.test.alex.test.Constant.START_TIME;

/**
 * Created by alex on 14.08.17.
 */

public class Event implements IModel {
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
    public String getInfoFromModel() {
        StringBuffer buffer = new StringBuffer(this.getClass().getSimpleName());
        buffer.append("\n ");
        buffer.append(START_TIME);
        buffer.append(": ");
        buffer.append(FULL_FORMAT.format(startTime));
        buffer.append("\n ");
        buffer.append(END_TIME);
        buffer.append(": ");
        buffer.append(FULL_FORMAT.format(endTime));
        buffer.append("\n ");
        buffer.append(NAME);
        buffer.append(" - ");
        buffer.append(name);
        return buffer.toString();
    }
}
