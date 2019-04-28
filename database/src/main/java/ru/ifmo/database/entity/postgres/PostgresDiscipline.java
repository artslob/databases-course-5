package ru.ifmo.database.entity.postgres;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "discipline", schema = "public", catalog = "ifmo_hibd")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PostgresDiscipline {
    @Id
    @Column(name = "discipline_id")
    private int disciplineId;
    @NotNull
    @Size(max = 100)
    private String name;
    @NotNull
    private int lectures;
    @NotNull
    @Column(name = "practical_lessons")
    private int practicalLessons;
    @NotNull
    private int labs;
    @NotNull
    @Column(name = "control_form")
    private String controlForm;
    @NotNull
    private int semester;
    @NotNull
    @Column(name = "department_id")
    private int departmentId;
}
