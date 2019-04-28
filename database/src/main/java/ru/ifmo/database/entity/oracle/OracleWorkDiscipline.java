package ru.ifmo.database.entity.oracle;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "WORK_DISCIPLINE", schema = "IFMO", catalog = "")
@IdClass(OracleWorkDisciplinePK.class)
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OracleWorkDiscipline {
    @Id
    @NotNull
    @Column(name = "work_id")
    private int workId;
    @Id
    @NotNull
    @Column(name = "discipline_id")
    private int disciplineId;
}
