package me.jivimberg.android.sugartestapp.model;

import com.orm.SugarRecord;

public class Category extends SugarRecord {
    private String name;

    public Category(){

    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}