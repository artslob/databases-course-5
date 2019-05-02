package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "HOSTEL")
public class UnionHostel {
    @Id
    @Column(name = "HOSTEL_ID")
    private int hostelId;
    @Basic
    @Column(name = "ADDRESS", nullable = false, length = 100)
    private String address;
    @Basic
    @Column(name = "ROOMS", nullable = false)
    private int rooms;
}
