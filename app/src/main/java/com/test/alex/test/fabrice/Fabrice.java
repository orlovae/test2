package com.test.alex.test.fabrice;

import com.test.alex.test.model.Event;
import com.test.alex.test.model.Move;
import com.test.alex.test.model.Notice;

import java.util.Date;

/**
 * Created by alex on 10.10.17.
 */

public class Fabrice implements IFabrice {
    @Override
    public Event createEvent() {
        Date startTime = new Date((long) (Math.random()*1000000));
        Date endTime = new Date((long) (Math.random()*1000000));
        String name = "name" + (int)(Math.random()*100);
        return new Event(startTime, endTime, name);
    }

    @Override
    public Move createMove() {
        String fromPlace = "fromPlace" + (int)(Math.random()*100);
        String toPlace = "toPlace" + (int)(Math.random()*100);
        Date estimaTime = new Date((long) (Math.random()*1000000));

        return new Move(fromPlace, toPlace, estimaTime);
    }

    @Override
    public Notice createNotice() {
        Date flightDate = new Date((long) (Math.random()*1000000));
        String gate = "gate" + (int)(Math.random()*100);

        return new Notice(flightDate, gate);
    }
}
