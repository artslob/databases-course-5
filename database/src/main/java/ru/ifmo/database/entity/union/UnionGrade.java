package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "GRADE", schema = "IFMO", catalog = "")
public class UnionGrade {
    private long gradeId;
    private long grade;
    private Time gradeDate;

    @Id
    @Column(name = "GRADE_ID")
    public long getGradeId() {
        return gradeId;
    }

    public void setGradeId(long gradeId) {
        this.gradeId = gradeId;
    }

    @Basic
    @Column(name = "GRADE")
    public long getGrade() {
        return grade;
    }

    public void setGrade(long grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "GRADE_DATE")
    public Time getGradeDate() {
        return gradeDate;
    }

    public void setGradeDate(Time gradeDate) {
        this.gradeDate = gradeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionGrade that = (UnionGrade) o;
        return gradeId == that.gradeId &&
                grade == that.grade &&
                Objects.equals(gradeDate, that.gradeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeId, grade, gradeDate);
    }
}
