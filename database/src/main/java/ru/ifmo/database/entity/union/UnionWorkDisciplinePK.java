package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UnionWorkDisciplinePK implements Serializable {
    @Column(name = "WORK_ID")
    @Id
    private int workId;
    @Column(name = "DISCIPLINE_ID")
    @Id
    private int disciplineId;
}
