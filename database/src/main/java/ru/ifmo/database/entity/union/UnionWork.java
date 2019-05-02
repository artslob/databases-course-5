package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "WORK")
public class UnionWork {
    @Id
    @Column(name = "WORK_ID")
    private int workId;
    @Basic
    @Column(name = "POSITION", nullable = false, length = 20)
    private String position;
    @Basic
    @Column(name = "WORK_START", nullable = false)
    private Date workStart;
    @Basic
    @Column(name = "WORK_END")
    private Date workEnd;
    @Column(name = "person_id")
    private int personId;
}
