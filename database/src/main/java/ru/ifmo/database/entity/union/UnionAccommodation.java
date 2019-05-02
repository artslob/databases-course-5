package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ACCOMMODATION")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UnionAccommodation {
    @Id
    @Column(name = "ACCOMMODATION_ID")
    private int accommodationId;
    @Basic
    @Column(name = "ACC_FROM", nullable = false)
    private Date accFrom;
    @Basic
    @Column(name = "ACC_TO")
    private Date accTo;
    @Basic
    @Column(name = "EXEMPTION", nullable = false)
    private int exemption;
    @Column(name = "person_id")
    private int personId;
    @Column(name = "room_id")
    private int roomId;
}
