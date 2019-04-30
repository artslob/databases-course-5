package ru.ifmo.database.entity.postgres;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

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
    @Column(name = "grade_date")
    private Timestamp gradeDate;
    @NotNull
    @Column(name = "person_id")
    private int personId;
    @NotNull
    @Column(name = "discipline_id")
    private int disciplineId;
}
