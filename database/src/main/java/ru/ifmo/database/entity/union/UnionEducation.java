package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "EDUCATION", schema = "IFMO", catalog = "")
public class UnionEducation {
    @Id
    @Column(name = "EDUCATION_ID")
    private long educationId;
    @Basic
    @Column(name = "EDUCATION_TYPE")
    private String educationType;
    @Basic
    @Column(name = "EDUCATION_FORM")
    private String educationForm;
    @Basic
    @Column(name = "QUALIFICATION")
    private String qualification;
    @Basic
    @Column(name = "START_DATE")
    private Time startDate;
    @Basic
    @Column(name = "END_DATE")
    private Time endDate;
    @Basic
    @Column(name = "COURSE")
    private long course;
}
