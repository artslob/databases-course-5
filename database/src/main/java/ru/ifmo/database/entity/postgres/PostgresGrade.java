package ru.ifmo.database.entity.postgres;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "grade", schema = "public", catalog = "ifmo_hibd")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PostgresGrade {
    @Id
    @Column(name = "grade_id")
    private int gradeId;
    @NotNull
    private int grade;
    @NotNull
    private Timestamp date;
    @NotNull
    @Column(name = "person_id")
    private int personId;
    @NotNull
    @Column(name = "discipline_id")
    private int disciplineId;
}
