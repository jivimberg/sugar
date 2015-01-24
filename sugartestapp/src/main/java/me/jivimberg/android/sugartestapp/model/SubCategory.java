package me.jivimberg.android.sugartestapp.model;

import com.orm.SugarRecord;

public class SubCategory extends SugarRecord {
    private Category category;

    public SubCategory(){

    }

    public SubCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
