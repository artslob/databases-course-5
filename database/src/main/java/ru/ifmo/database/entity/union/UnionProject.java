package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "projectId")
@Entity
@Table(name = "PROJECT")
public class UnionProject {
    @Id
    @Column(name = "PROJECT_ID")
    private int projectId;
    @Basic
    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;
    @Basic
    @Column(name = "PROJECT_START", nullable = false)
    private Date projectStart;
    @Basic
    @Column(name = "PROJECT_END")
    private Date projectEnd;
}
