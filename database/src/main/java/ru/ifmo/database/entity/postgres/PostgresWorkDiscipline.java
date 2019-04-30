package ru.ifmo.database.entity.postgres;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "work_discipline", schema = "public", catalog = "ifmo_hibd")
@IdClass(PostgresWorkDisciplinePK.class)
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PostgresWorkDiscipline {
    @Id
    @Column(name = "work_id")
    private int workId;
    @Id
    @Column(name = "discipline_id")
    private int disciplineId;
}
