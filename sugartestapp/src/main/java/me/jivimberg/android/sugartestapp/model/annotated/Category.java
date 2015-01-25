package me.jivimberg.android.sugartestapp.model.annotated;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

@Table(name = "category")
public class Category {
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