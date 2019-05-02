package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "GRADE")
public class UnionGrade {
    @Id
    @Column(name = "GRADE_ID")
    private int gradeId;
    @Basic
    @Column(name = "GRADE", nullable = false)
    private int grade;
    @Basic
    @Column(name = "GRADE_DATE")
    private Date gradeDate;
    @Column(name = "person_id")
    private int personId;
    @Column(name = "discipline_id")
    private int disciplineId;
}
