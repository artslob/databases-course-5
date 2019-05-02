package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "UNIVERSITY", schema = "IFMO", catalog = "")
public class UnionUniversity {
    @Id
    @Column(name = "UNIVERSITY_ID")
    private long universityId;
    @Basic
    @Column(name = "NAME")
    private String name;
}
