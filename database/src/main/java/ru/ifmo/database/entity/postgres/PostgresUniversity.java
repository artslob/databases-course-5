package ru.ifmo.database.entity.postgres;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "university", schema = "public", catalog = "ifmo_hibd")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PostgresUniversity {
    @Id
    @Column(name = "university_id")
    private int universityId;
    @NotNull
    @Size(max = 100)
    private String name;
}
