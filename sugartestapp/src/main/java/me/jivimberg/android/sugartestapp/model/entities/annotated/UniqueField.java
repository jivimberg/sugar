package me.jivimberg.android.sugartestapp.model.entities.annotated;

import com.orm.dsl.Column;
import com.orm.dsl.NotNull;
import com.orm.dsl.Table;

import me.jivimberg.android.sugartestapp.model.entities.SugarEntity;

@Table(name = "Project")
public class UniqueField implements SugarEntity {
    @Column(name = "projectId", unique = true, notNull = true)
    private int id;
    @NotNull private String name;

    public UniqueField(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public UniqueField() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
