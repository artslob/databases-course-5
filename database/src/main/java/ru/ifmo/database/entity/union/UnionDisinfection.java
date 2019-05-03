package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "disinfectionId")
@Entity
@Table(name = "DISINFECTION")
public class UnionDisinfection {
    @Id
    @Column(name = "DISINFECTION_ID")
    private int disinfectionId;
    @Basic
    @Column(name = "DISINFECTION_DATE", nullable = false)
    private Date disinfectionDate;
    @Column(name = "room_id")
    private int roomId;
}
