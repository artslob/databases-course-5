package ru.ifmo.database.entity.postgres;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "discipline", schema = "public", catalog = "ifmo_hibd")
public class PostgresDiscipline {
    private int disciplineId;
    private String name;
    private int lectures;
    private int practicalLessons;
    private int labs;
    private String controlForm;
    private int semester;
    private PostgresDepartment departmentByDepartmentId;

    @Id
    @Column(name = "discipline_id", nullable = false)
    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "lectures", nullable = false)
    public int getLectures() {
        return lectures;
    }

    public void setLectures(int lectures) {
        this.lectures = lectures;
    }

    @Basic
    @Column(name = "practical_lessons", nullable = false)
    public int getPracticalLessons() {
        return practicalLessons;
    }

    public void setPracticalLessons(int practicalLessons) {
        this.practicalLessons = practicalLessons;
    }

    @Basic
    @Column(name = "labs", nullable = false)
    public int getLabs() {
        return labs;
    }

    public void setLabs(int labs) {
        this.labs = labs;
    }

    @Basic
    @Column(name = "control_form", nullable = false, length = 10)
    public String getControlForm() {
        return controlForm;
    }

    public void setControlForm(String controlForm) {
        this.controlForm = controlForm;
    }

    @Basic
    @Column(name = "semester", nullable = false)
    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostgresDiscipline that = (PostgresDiscipline) o;
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

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false)
    public PostgresDepartment getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(PostgresDepartment departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }

    @Override
    public String toString() {
        return "PostgresDiscipline{" +
                "disciplineId=" + disciplineId +
                ", name='" + name + '\'' +
                ", lectures=" + lectures +
                ", practicalLessons=" + practicalLessons +
                ", labs=" + labs +
                ", controlForm='" + controlForm + '\'' +
                ", semester=" + semester +
                ", departmentByDepartmentId=" + departmentByDepartmentId +
                '}';
    }
}
