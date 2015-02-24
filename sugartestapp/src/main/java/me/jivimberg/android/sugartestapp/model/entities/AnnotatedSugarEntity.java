package me.jivimberg.android.sugartestapp.model.entities;

import com.orm.dsl.NotNull;
import com.orm.dsl.Table;

import me.jivimberg.android.sugartestapp.model.entities.SugarEntity;

@Table
public class AnnotatedSugarEntity implements SugarEntity {

    @NotNull
    private String name;

    public AnnotatedSugarEntity(String name) {
        this.name = name;
    }

    public AnnotatedSugarEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
