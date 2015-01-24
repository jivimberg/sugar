package me.jivimberg.android.sugartestapp.model.extended;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

public class SubCategoryExtending extends SugarRecord {
    private CategoryExtending category;

    public SubCategoryExtending(){

    }

    public SubCategoryExtending(CategoryExtending category) {
        this.category = category;
    }

    public CategoryExtending getCategory() {
        return category;
    }
}
