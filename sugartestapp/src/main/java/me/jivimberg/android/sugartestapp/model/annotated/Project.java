package me.jivimberg.android.sugartestapp.model.annotated;

import com.orm.dsl.Column;
import com.orm.dsl.NotNull;
import com.orm.dsl.Table;

@Table(name = "Project")
public class Project {
    @Column(name = "projectId", unique = true, notNull = true)
    private int id;
    @NotNull private String name;

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Project() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
