package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "DISCIPLINE", schema = "IFMO", catalog = "")
public class UnionDiscipline {
    @Id
    @Column(name = "DISCIPLINE_ID")
    private long disciplineId;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "LECTURES")
    private long lectures;
    @Basic
    @Column(name = "PRACTICAL_LESSONS")
    private long practicalLessons;
    @Basic
    @Column(name = "LABS")
    private long labs;
    @Basic
    @Column(name = "CONTROL_FORM")
    private String controlForm;
    @Basic
    @Column(name = "SEMESTER")
    private long semester;
}
