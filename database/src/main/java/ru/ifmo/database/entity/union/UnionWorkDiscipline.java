package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "WORK_DISCIPLINE", schema = "IFMO", catalog = "")
@IdClass(UnionWorkDisciplinePK.class)
public class UnionWorkDiscipline {
    @Id
    @Column(name = "WORK_ID")
    private long workId;
    @Id
    @Column(name = "DISCIPLINE_ID")
    private long disciplineId;
}
