package ru.ifmo.database.entity.oracle;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DEPARTMENT", schema = "IFMO", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OracleDepartment {
    @Id
    @Column(name = "department_id")
    private int departmentId;
    @NotNull
    @Size(max = 100)
    private String faculty;
    @NotNull
    @Size(max = 100)
    private String direction;
    @NotNull
    @Size(max = 100)
    private String specialty;
}
