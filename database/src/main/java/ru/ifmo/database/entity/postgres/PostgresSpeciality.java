package ru.ifmo.database.entity.postgres;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "speciality", schema = "public", catalog = "ifmo_hibd")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "specialityId")
public class PostgresSpeciality {
    @Id
    @Column(name = "speciality_id")
    private int specialityId;
    @NotNull
    @Size(max = 100)
    private String name;
    @NotNull
    @Size(max = 10)
    private String standard;
    @NotNull
    @Column(name = "department_id")
    private int departmentId;
}
