package me.jivimberg.android.sugartestapp.model;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != project.id) return false;
        if (name != null ? !name.equals(project.name) : project.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
