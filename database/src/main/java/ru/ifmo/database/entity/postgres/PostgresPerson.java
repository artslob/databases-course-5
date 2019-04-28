package ru.ifmo.database.entity.postgres;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "person", schema = "public", catalog = "ifmo_hibd")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PostgresPerson {
    @Id
    @Column(name = "person_id")
    private int personId;
    @NotNull
    @Size(max = 20)
    private String name;
    @NotNull
    @Size(max = 20)
    private String surname;
    @NotNull
    @Size(max = 20)
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "person_type")
    private String personType;
    @Column(name = "department_id")
    private Integer departmentId;
}
