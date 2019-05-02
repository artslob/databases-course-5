package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "PROJECT", schema = "IFMO", catalog = "")
public class UnionProject {
    @Id
    @Column(name = "PROJECT_ID")
    private long projectId;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "PROJECT_START")
    private Time projectStart;
    @Basic
    @Column(name = "PROJECT_END")
    private Time projectEnd;
}
