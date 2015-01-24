package me.jivimberg.android.sugartestapp.model.extended;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

public class CategoryExtending extends SugarRecord {
    private String name;

    public CategoryExtending(){

    }

    public CategoryExtending(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}