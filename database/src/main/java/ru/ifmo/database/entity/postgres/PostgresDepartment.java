package ru.ifmo.database.entity.postgres;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "department", schema = "public", catalog = "ifmo_hibd")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "departmentId")
public class PostgresDepartment {
    @Id
    @Column(name = "department_id")
    private int departmentId;
    @NotNull
    @Size(max = 100)
    private String faculty;
    @Column(name = "university_id")
    private int universityId;
}
