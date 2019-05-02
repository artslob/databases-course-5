package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "SPECIALITY", schema = "IFMO", catalog = "")
public class UnionSpeciality {
    @Id
    @Column(name = "SPECIALITY_ID")
    private long specialityId;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "DIRECTION")
    private String direction;
    @Basic
    @Column(name = "STANDARD")
    private String standard;
}
