package ru.ifmo.database.entity.mysql;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person", schema = "ifmo_hibd", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MySQLPerson {
    @Id
    @Column(name = "person_id", nullable = false)
    private int personId;
    @Basic
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Basic
    @Column(name = "surname", nullable = false, length = 20)
    private String surname;
    @Basic
    @Column(name = "middle_name", nullable = true, length = 20)
    private String middleName;
    @Basic
    @Column(name = "position", nullable = false)
    private String position;
}
