package me.jivimberg.android.sugartestapp.model.entities.extended;

import com.orm.SugarRecord;

public class ChildExtended extends SugarRecord {
    private ParentExtended category;

    public ChildExtended(){

    }

    public ChildExtended(ParentExtended category) {
        this.category = category;
    }

    public ParentExtended getCategory() {
        return category;
    }
}
