package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "DEPARTMENT", schema = "IFMO", catalog = "")
public class UnionDepartment {
    @Id
    @Column(name = "DEPARTMENT_ID")
    private long departmentId;

    @Basic
    @Column(name = "FACULTY")
    private String faculty;
}
