package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "EDUCATION", schema = "IFMO", catalog = "")
public class UnionEducation {
    private long educationId;
    private String educationType;
    private String educationForm;
    private String qualification;
    private Time startDate;
    private Time endDate;
    private long course;

    @Id
    @Column(name = "EDUCATION_ID")
    public long getEducationId() {
        return educationId;
    }

    public void setEducationId(long educationId) {
        this.educationId = educationId;
    }

    @Basic
    @Column(name = "EDUCATION_TYPE")
    public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    @Basic
    @Column(name = "EDUCATION_FORM")
    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
        this.educationForm = educationForm;
    }

    @Basic
    @Column(name = "QUALIFICATION")
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Basic
    @Column(name = "START_DATE")
    public Time getStartDate() {
        return startDate;
    }

    public void setStartDate(Time startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "END_DATE")
    public Time getEndDate() {
        return endDate;
    }

    public void setEndDate(Time endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "COURSE")
    public long getCourse() {
        return course;
    }

    public void setCourse(long course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionEducation that = (UnionEducation) o;
        return educationId == that.educationId &&
                course == that.course &&
                Objects.equals(educationType, that.educationType) &&
                Objects.equals(educationForm, that.educationForm) &&
                Objects.equals(qualification, that.qualification) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(educationId, educationType, educationForm, qualification, startDate, endDate, course);
    }
}
