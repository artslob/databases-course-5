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
@Table(name = "VISIT", schema = "IFMO", catalog = "")
public class UnionVisit {
    @Id
    @Column(name = "VISIT_ID")
    private long visitId;
    @Basic
    @Column(name = "INSIDE")
    private Time inside;
    @Basic
    @Column(name = "OUTSIDE")
    private Time outside;
}
