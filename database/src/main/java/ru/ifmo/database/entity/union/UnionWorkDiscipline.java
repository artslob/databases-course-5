package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "WORK_DISCIPLINE")
@IdClass(UnionWorkDisciplinePK.class)
public class UnionWorkDiscipline {
    @Id
    @Column(name = "WORK_ID")
    private int workId;
    @Id
    @Column(name = "DISCIPLINE_ID")
    private int disciplineId;
}
