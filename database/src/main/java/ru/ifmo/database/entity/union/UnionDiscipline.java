package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DISCIPLINE", schema = "IFMO", catalog = "")
public class UnionDiscipline {
    private long disciplineId;
    private String name;
    private long lectures;
    private long practicalLessons;
    private long labs;
    private String controlForm;
    private long semester;

    @Id
    @Column(name = "DISCIPLINE_ID")
    public long getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(long disciplineId) {
        this.disciplineId = disciplineId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "LECTURES")
    public long getLectures() {
        return lectures;
    }

    public void setLectures(long lectures) {
        this.lectures = lectures;
    }

    @Basic
    @Column(name = "PRACTICAL_LESSONS")
    public long getPracticalLessons() {
        return practicalLessons;
    }

    public void setPracticalLessons(long practicalLessons) {
        this.practicalLessons = practicalLessons;
    }

    @Basic
    @Column(name = "LABS")
    public long getLabs() {
        return labs;
    }

    public void setLabs(long labs) {
        this.labs = labs;
    }

    @Basic
    @Column(name = "CONTROL_FORM")
    public String getControlForm() {
        return controlForm;
    }

    public void setControlForm(String controlForm) {
        this.controlForm = controlForm;
    }

    @Basic
    @Column(name = "SEMESTER")
    public long getSemester() {
        return semester;
    }

    public void setSemester(long semester) {
        this.semester = semester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionDiscipline that = (UnionDiscipline) o;
        return disciplineId == that.disciplineId &&
                lectures == that.lectures &&
                practicalLessons == that.practicalLessons &&
                labs == that.labs &&
                semester == that.semester &&
                Objects.equals(name, that.name) &&
                Objects.equals(controlForm, that.controlForm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplineId, name, lectures, practicalLessons, labs, controlForm, semester);
    }
}
