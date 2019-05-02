package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DEPARTMENT", schema = "IFMO", catalog = "")
public class UnionDepartment {
    private long departmentId;
    private String faculty;

    @Id
    @Column(name = "DEPARTMENT_ID")
    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "FACULTY")
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionDepartment that = (UnionDepartment) o;
        return departmentId == that.departmentId &&
                Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, faculty);
    }
}
