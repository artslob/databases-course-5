package ru.ifmo.database.entity.oracle;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "WORK", schema = "IFMO", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "workId")
public class OracleWork {
    @Id
    @Column(name = "work_id")
    private int workId;
    @NotNull
    @Size(max = 20)
    private String position;
    @NotNull
    @Column(name = "work_start")
    private Date workStart;
    @Column(name = "work_end")
    private Date workEnd;
    @Column(name = "person_id")
    private int personId;
}
