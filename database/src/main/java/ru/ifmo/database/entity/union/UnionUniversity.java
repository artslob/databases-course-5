package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "UNIVERSITY")
public class UnionUniversity {
    @Id
    @Column(name = "UNIVERSITY_ID")
    private int universityId;
    @Basic
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;
}
