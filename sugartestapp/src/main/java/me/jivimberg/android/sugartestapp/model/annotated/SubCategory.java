package me.jivimberg.android.sugartestapp.model.annotated;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

@Table(name = "subcategory")
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
