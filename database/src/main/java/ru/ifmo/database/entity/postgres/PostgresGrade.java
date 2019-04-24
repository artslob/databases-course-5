package ru.ifmo.database.entity.postgres;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "grade", schema = "public", catalog = "ifmo_hibd")
public class PostgresGrade {
    private int gradeId;
    private int grade;
    private Timestamp date;
    private PostgresDiscipline disciplineByDisciplineId;

    @Id
    @Column(name = "grade_id", nullable = false)
    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    @Basic
    @Column(name = "grade", nullable = false)
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostgresGrade that = (PostgresGrade) o;
        return gradeId == that.gradeId &&
                grade == that.grade &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeId, grade, date);
    }

    @ManyToOne
    @JoinColumn(name = "discipline_id", referencedColumnName = "discipline_id", nullable = false)
    public PostgresDiscipline getDisciplineByDisciplineId() {
        return disciplineByDisciplineId;
    }

    public void setDisciplineByDisciplineId(PostgresDiscipline disciplineByDisciplineId) {
        this.disciplineByDisciplineId = disciplineByDisciplineId;
    }

    @Override
    public String toString() {
        return "PostgresGrade{" +
                "gradeId=" + gradeId +
                ", grade=" + grade +
                ", date=" + date +
                ", disciplineByDisciplineId=" + disciplineByDisciplineId +
                '}';
    }
}
