package com.test.alex.test.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import static com.test.alex.test.Constant.ESTIMAL_TIME;
import static com.test.alex.test.Constant.FROM_PLACE;
import static com.test.alex.test.Constant.FULL_FORMAT;
import static com.test.alex.test.Constant.TO_PLACE;

/**
 * Created by alex on 14.08.17.
 */

public class Move implements IModel {
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

    @Override
    public String getInfoFromModel() {
        StringBuffer buffer = new StringBuffer(this.getClass().getSimpleName());
        buffer.append("\n ");
        buffer.append(FROM_PLACE);
        buffer.append(" - ");
        buffer.append(fromPlace);
        buffer.append("\n ");
        buffer.append(TO_PLACE);
        buffer.append(" - ");
        buffer.append(toPlace);
        buffer.append("\n ");
        buffer.append(ESTIMAL_TIME);
        buffer.append(": ");
        buffer.append(FULL_FORMAT.format(estimalTime));
        return buffer.toString();
    }
}
