package com.thirdeyews.droidframework.support;

/**
 * Created by kapil on 26/01/17.
 */
public class Lists {
    public int id;
    public String desc;

    public Lists(int id, String desc)
    {
        this.id=id;
        this.desc=desc;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMessage() {
        return desc;
    }
    public void setMessage(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return  desc;
    }
}
