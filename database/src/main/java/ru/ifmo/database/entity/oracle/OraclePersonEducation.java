package ru.ifmo.database.entity.oracle;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PERSON_EDUCATION", schema = "IFMO", catalog = "")
@IdClass(OraclePersonEducationPK.class)
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OraclePersonEducation {
    @Id
    @NotNull
    @Column(name = "work_id")
    private int personId;
    @Id
    @NotNull
    @Column(name = "discipline_id")
    private int educationId;
}
