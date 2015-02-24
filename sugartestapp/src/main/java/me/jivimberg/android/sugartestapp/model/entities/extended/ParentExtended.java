package me.jivimberg.android.sugartestapp.model.entities.extended;

import com.orm.SugarRecord;

import me.jivimberg.android.sugartestapp.model.entities.SugarEntity;

public class ParentExtended extends SugarRecord implements SugarEntity {
    private String name;

    public ParentExtended(){

    }

    public ParentExtended(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}