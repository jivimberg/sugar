package me.jivimberg.android.sugartestapp.model.entities;

import com.orm.SugarRecord;
import com.orm.dsl.NotNull;
import com.orm.dsl.Table;

import me.jivimberg.android.sugartestapp.model.entities.SugarEntity;

public class ExtendedSugarEntity extends SugarRecord implements SugarEntity{

    @NotNull
    private String name;

    public ExtendedSugarEntity(String name) {
        this.name = name;
    }

    public ExtendedSugarEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ExtendedSugarEntity findById(Long id) {
        return findById(ExtendedSugarEntity.class, id);
    }
}
