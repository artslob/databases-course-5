package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "visitId")
@Entity
@Table(name = "VISIT")
public class UnionVisit {
    @Id
    @Column(name = "VISIT_ID")
    private int visitId;
    @Basic
    @Column(name = "INSIDE")
    private Date inside;
    @Basic
    @Column(name = "OUTSIDE")
    private Date outside;
    @Column(name = "person_id")
    private int personId;
    @Column(name = "hostel_id")
    private int hostelId;
}
