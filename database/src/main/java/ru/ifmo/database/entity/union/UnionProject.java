package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "PROJECT", schema = "IFMO", catalog = "")
public class UnionProject {
    private long projectId;
    private String title;
    private Time projectStart;
    private Time projectEnd;

    @Id
    @Column(name = "PROJECT_ID")
    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "PROJECT_START")
    public Time getProjectStart() {
        return projectStart;
    }

    public void setProjectStart(Time projectStart) {
        this.projectStart = projectStart;
    }

    @Basic
    @Column(name = "PROJECT_END")
    public Time getProjectEnd() {
        return projectEnd;
    }

    public void setProjectEnd(Time projectEnd) {
        this.projectEnd = projectEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionProject that = (UnionProject) o;
        return projectId == that.projectId &&
                Objects.equals(title, that.title) &&
                Objects.equals(projectStart, that.projectStart) &&
                Objects.equals(projectEnd, that.projectEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, title, projectStart, projectEnd);
    }
}
