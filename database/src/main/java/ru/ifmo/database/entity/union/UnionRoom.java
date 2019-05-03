package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "roomId")
@Entity
@Table(name = "ROOM")
public class UnionRoom {
    @Id
    @Column(name = "ROOM_ID")
    private int roomId;
    @Basic
    @Column(name = "ROOM_NUMBER", nullable = false)
    private int roomNumber;
    @Basic
    @Column(name = "CAPACITY", nullable = false)
    private int capacity;
    @Basic
    @Column(name = "PAYMENT", nullable = false)
    private int payment;
    @Basic
    @Column(name = "INSECTS", nullable = false)
    private int insects;
    @Column(name = "hostel_id")
    private int hostelId;
}
