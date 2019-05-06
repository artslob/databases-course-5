package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "educationId")
@Entity
@Table(name = "EDUCATION")
public class UnionEducation {
    @Id
    @Column(name = "EDUCATION_ID")
    private int educationId;
    @Basic
    @Column(name = "EDUCATION_TYPE", nullable = false, length = 100)
    private String educationType;
    @Basic
    @Column(name = "EDUCATION_FORM", nullable = false, length = 100)
    private String educationForm;
    @Basic
    @Column(name = "QUALIFICATION", nullable = false, length = 100)
    private String qualification;
    @Basic
    @Column(name = "START_DATE", nullable = false)
    private Date startDate;
    @Basic
    @Column(name = "END_DATE")
    private Date endDate;
    @Basic
    @Column(name = "COURSE", nullable = false)
    private int course;
    @Column(name = "speciality_id")
    private int specialityId;
    @Column(name = "person_id")
    private int personId;
}
