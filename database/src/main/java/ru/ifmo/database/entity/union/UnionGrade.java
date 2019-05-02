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
@Table(name = "GRADE", schema = "IFMO", catalog = "")
public class UnionGrade {
    @Id
    @Column(name = "GRADE_ID")
    private long gradeId;
    @Basic
    @Column(name = "GRADE")
    private long grade;
    @Basic
    @Column(name = "GRADE_DATE")
    private Time gradeDate;
}
