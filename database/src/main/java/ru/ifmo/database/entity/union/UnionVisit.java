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
@Table(name = "VISIT")
public class UnionVisit {
    @Id
    @Column(name = "VISIT_ID")
    private int visitId;
    @Basic
    @Column(name = "INSIDE")
    private Time inside;
    @Basic
    @Column(name = "OUTSIDE")
    private Time outside;
    @Column(name = "person_id")
    private int personId;
    @Column(name = "hostel_id")
    private int hostelId;
}
