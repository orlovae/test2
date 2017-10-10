package com.test.alex.test.model;

import java.util.Date;

/**
 * Created by alex on 09.10.17.
 */

public interface IModel {
    /**Event**/
    public abstract Date getStartTime();
    public abstract Date getEndTime();
    public abstract String getName();

    public abstract void setStartTime(Date startTime);
    public abstract void setEndTime(Date endTime);
    public abstract void setName(String name);

    /**Move**/
    public abstract String getFromPlace();
    public abstract String getToPlace();
    public abstract Date getEstimalTime();

    public abstract void setFromPlace(String fromPlace);
    public abstract void setToPlace(String toPlace);
    public abstract void setEstimalTime(Date estimalTime);

    /**Notice**/
    public abstract Date getFlightDate();
    public abstract String getGate();

    public abstract void setFlightDate(Date flightDate);
    public abstract void setGate(String gate);
}
