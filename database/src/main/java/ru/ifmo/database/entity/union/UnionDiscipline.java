package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "disciplineId")
@Entity
@Table(name = "DISCIPLINE")
public class UnionDiscipline {
    @Id
    @Column(name = "DISCIPLINE_ID")
    private int disciplineId;
    @Basic
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "LECTURES", nullable = false)
    private int lectures;
    @Basic
    @Column(name = "PRACTICAL_LESSONS", nullable = false)
    private int practicalLessons;
    @Basic
    @Column(name = "LABS", nullable = false)
    private int labs;
    @Basic
    @Column(name = "CONTROL_FORM",  nullable = false, length = 10)
    private String controlForm;
    @Basic
    @Column(name = "SEMESTER", nullable = false)
    private int semester;
    @Column(name = "speciality_id")
    private int specialityId;
}
