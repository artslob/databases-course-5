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
    private int personId;
    private int disciplineId;

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

    @Basic
    @Column(name = "person_id", nullable = false)
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "discipline_id", nullable = false)
    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostgresGrade that = (PostgresGrade) o;
        return gradeId == that.gradeId &&
                grade == that.grade &&
                personId == that.personId &&
                disciplineId == that.disciplineId &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeId, grade, date, personId, disciplineId);
    }

    @Override
    public String toString() {
        return "PostgresGrade{" +
                "gradeId=" + gradeId +
                ", grade=" + grade +
                ", date=" + date +
                ", personId=" + personId +
                ", disciplineId=" + disciplineId +
                '}';
    }
}
