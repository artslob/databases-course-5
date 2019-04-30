package ru.ifmo.database.entity.postgres;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PostgresWorkDisciplinePK implements Serializable {
    @Id
    @Column(name = "work_id", nullable = false)
    private int workId;
    @Id
    @Column(name = "discipline_id", nullable = false)
    private int disciplineId;
}
