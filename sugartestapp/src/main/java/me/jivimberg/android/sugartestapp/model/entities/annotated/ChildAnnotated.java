package me.jivimberg.android.sugartestapp.model.entities.annotated;

import com.orm.dsl.Table;

@Table(name = "subcategory")
public class ChildAnnotated {
    private ParentAnnotated parentAnnotated;

    public ChildAnnotated(){

    }

    public ChildAnnotated(ParentAnnotated parentAnnotated) {
        this.parentAnnotated = parentAnnotated;
    }

    public ParentAnnotated getParent() {
        return parentAnnotated;
    }
}
