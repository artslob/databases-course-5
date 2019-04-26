package ru.ifmo.database.entity.postgres;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "department", schema = "public", catalog = "ifmo_hibd")
public class PostgresDepartment {
    private int departmentId;
    private String name;
    private String educationalForm;
    private String standard;
    private String faculty;
    private int universityId;

    @Id
    @Column(name = "department_id", nullable = false)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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
    @Column(name = "educational_form", nullable = false, length = 100)
    public String getEducationalForm() {
        return educationalForm;
    }

    public void setEducationalForm(String educationalForm) {
        this.educationalForm = educationalForm;
    }

    @Basic
    @Column(name = "standard", nullable = false, length = 10)
    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    @Basic
    @Column(name = "faculty", nullable = false, length = 100)
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Basic
    @Column(name = "university_id", nullable = false)
    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostgresDepartment that = (PostgresDepartment) o;
        return departmentId == that.departmentId &&
                universityId == that.universityId &&
                Objects.equals(name, that.name) &&
                Objects.equals(educationalForm, that.educationalForm) &&
                Objects.equals(standard, that.standard) &&
                Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, name, educationalForm, standard, faculty, universityId);
    }

    @Override
    public String toString() {
        return "PostgresDepartment{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", educationalForm='" + educationalForm + '\'' +
                ", standard='" + standard + '\'' +
                ", faculty='" + faculty + '\'' +
                ", universityId=" + universityId +
                '}';
    }
}
