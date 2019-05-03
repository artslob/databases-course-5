package ru.ifmo.database.entity.oracle;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "PERSON", schema = "IFMO", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "personId")
public class OraclePerson {
    @Id
    @Column(name = "person_id")
    private int personId;
    @NotNull
    @Size(max = 20)
    private String name;
    @NotNull
    @Size(max = 20)
    private String surname;
    @Size(max = 20)
    @Column(name = "middle_name")
    private String middleName;
    @NotNull
    private Date birthday;
    @NotNull
    @Size(max = 100)
    private String birthplace;
    @NotNull
    @Size(max = 20)
    @Column(name = "person_type")
    private String personType;
}
