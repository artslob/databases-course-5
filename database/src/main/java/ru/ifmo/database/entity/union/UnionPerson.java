package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "PERSON")
public class UnionPerson {
    @Id
    @Column(name = "PERSON_ID")
    private int personId;
    @Basic
    @Column(name = "NAME", nullable = false, length = 20)
    private String name;
    @Basic
    @Column(name = "SURNAME", nullable = false, length = 20)
    private String surname;
    @Basic
    @Column(name = "MIDDLE_NAME", length = 20)
    private String middleName;
    @Basic
    @Column(name = "BIRTHDAY", nullable = false)
    private Date birthday;
    @Basic
    @Column(name = "BIRTHPLACE",  nullable = false, length = 100)
    private String birthplace;
    @Basic
    @Column(name = "PERSON_TYPE", length = 20)
    private String personType;
    @Basic
    @Column(name = "POSITION", nullable = false, length = 20)
    private String position;
//    @Column(name = "study_type", nullable = false, length = 20)
//    private String studyType;
}
