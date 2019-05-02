package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "ROOM", schema = "IFMO", catalog = "")
public class UnionRoom {
    @Id
    @Column(name = "ROOM_ID")
    private long roomId;
    @Basic
    @Column(name = "ROOM_NUMBER")
    private long roomNumber;
    @Basic
    @Column(name = "CAPACITY")
    private long capacity;
    @Basic
    @Column(name = "PAYMENT")
    private long payment;
    @Basic
    @Column(name = "INSECTS")
    private long insects;
}
