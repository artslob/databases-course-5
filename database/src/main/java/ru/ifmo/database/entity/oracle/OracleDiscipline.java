package ru.ifmo.database.entity.oracle;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "DISCIPLINE", schema = "IFMO", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OracleDiscipline {
    @Id
    @Column(name = "discipline_id")
    private int disciplineId;
    @NotNull
    @Size(max = 100)
    private String name;
    @NotNull
    @Column(name = "speciality_id")
    private int specialityId;
}
