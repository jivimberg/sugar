package me.jivimberg.android.sugartestapp.model;

import com.orm.SugarRecord;
import com.orm.dsl.NotNull;

public class ProjectExtending extends SugarRecord {
    @NotNull private String name;

    public ProjectExtending(@NotNull String name) {
        this.name = name;
    }

    public ProjectExtending() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ProjectExtending findById(Long id) {
        return findById(ProjectExtending.class, id);
    }
}
