package ru.ifmo.database.entity.postgres;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "department", schema = "public", catalog = "ifmo_hibd")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PostgresDepartment {
    @Id
    @Column(name = "department_id")
    private int departmentId;
    @NotNull
    @Size(max = 100)
    private String name;
    @NotNull
    @Size(max = 100)
    @Column(name = "educational_form")
    private String educationalForm;
    @NotNull
    @Size(max = 10)
    private String standard;
    @NotNull
    @Size(max = 100)
    private String faculty;
    @Column(name = "university_id")
    private int universityId;
}
