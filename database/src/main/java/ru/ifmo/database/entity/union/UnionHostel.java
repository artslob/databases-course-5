package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "HOSTEL", schema = "IFMO", catalog = "")
public class UnionHostel {
    @Id
    @Column(name = "HOSTEL_ID")
    private long hostelId;
    @Basic
    @Column(name = "ADDRESS")
    private String address;
    @Basic
    @Column(name = "ROOMS")
    private long rooms;
}
