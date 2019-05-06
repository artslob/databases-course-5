package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "departmentId")
@Entity
@Table(name = "DEPARTMENT")
public class UnionDepartment {
    @Id
    @Column(name = "department_id")
    private int departmentId;
    @Basic
    @Column(name = "faculty")
    private String faculty;
    @Column(name = "university_id")
    private int universityId;
}
