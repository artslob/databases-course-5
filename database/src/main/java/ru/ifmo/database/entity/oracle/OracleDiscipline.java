package ru.ifmo.database.entity.oracle;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DISCIPLINE", schema = "IFMO", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "disciplineId")
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
