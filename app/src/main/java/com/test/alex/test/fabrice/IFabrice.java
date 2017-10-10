package com.test.alex.test.fabrice;

import com.test.alex.test.model.Event;
import com.test.alex.test.model.IModel;
import com.test.alex.test.model.Move;
import com.test.alex.test.model.Notice;

/**
 * Created by alex on 10.10.17.
 */

public interface IFabrice {
    public abstract Event createEvent();
    public abstract Move createMove();
    public abstract Notice createNotice();
}
