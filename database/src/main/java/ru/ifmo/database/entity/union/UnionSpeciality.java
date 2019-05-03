package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "specialityId")
@Entity
@Table(name = "SPECIALITY")
public class UnionSpeciality {
    @Id
    @Column(name = "SPECIALITY_ID")
    private int specialityId;
    @Basic
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "DIRECTION", nullable = false, length = 100)
    private String direction;
    @Basic
    @Column(name = "STANDARD", nullable = false, length = 10)
    private String standard;
    @Column(name = "department_id")
    private int departmentId;
}
