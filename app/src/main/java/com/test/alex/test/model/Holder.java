package com.test.alex.test.model;

/**
 * Created by alex on 14.08.17.
 */

public class Holder {
    private Object object;
    private String type;

    public Holder(Object object, String type) {
        this.object = object;
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
