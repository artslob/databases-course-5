package ru.ifmo.database.entity.postgres;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "work", schema = "public", catalog = "ifmo_hibd")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PostgresWork {
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
    @NotNull
    @Column(name = "person_id")
    private int personId;
}
