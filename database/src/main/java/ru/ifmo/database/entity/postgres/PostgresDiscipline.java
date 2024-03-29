package ru.ifmo.database.entity.postgres;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "discipline", schema = "public", catalog = "ifmo_hibd")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "disciplineId")
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
    @Column(name = "speciality_id")
    private int specialityId;
}
