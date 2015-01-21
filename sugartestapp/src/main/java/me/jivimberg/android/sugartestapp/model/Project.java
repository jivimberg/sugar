package me.jivimberg.android.sugartestapp.model;

import com.orm.dsl.Column;
import com.orm.dsl.NotNull;
import com.orm.dsl.Table;

@Table(name = "Project")
public class Project {
    @Column(name = "projectId", unique = true, notNull = true)
    private int id;
    @NotNull private String title;

    public Project(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Project() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != project.id) return false;
        if (title != null ? !title.equals(project.title) : project.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
