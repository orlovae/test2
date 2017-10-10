package com.test.alex.test.model;

/**
 * Created by alex on 14.08.17.
 */

public class Holder<T extends IModel>{
    T model;

    public Holder(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public String showType() {
        return model.getClass().getSimpleName();
    }
}
