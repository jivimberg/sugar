package me.jivimberg.android.sugartestapp.model.entities.annotated;

import com.orm.dsl.Table;

import me.jivimberg.android.sugartestapp.model.entities.SugarEntity;

@Table(name = "category")
public class ParentAnnotated implements SugarEntity{
    private String name;

    public ParentAnnotated(){

    }

    public ParentAnnotated(String name) {
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