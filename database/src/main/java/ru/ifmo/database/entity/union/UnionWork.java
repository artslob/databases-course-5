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
@Table(name = "WORK", schema = "IFMO", catalog = "")
public class UnionWork {
    @Id
    @Column(name = "WORK_ID")
    private long workId;
    @Basic
    @Column(name = "POSITION")
    private String position;
    @Basic
    @Column(name = "WORK_START")
    private Time workStart;
    @Basic
    @Column(name = "WORK_END")
    private Time workEnd;
}
