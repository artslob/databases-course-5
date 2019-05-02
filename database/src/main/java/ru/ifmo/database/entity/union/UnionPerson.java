package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "PERSON", schema = "IFMO", catalog = "")
public class UnionPerson {
    @Id
    @Column(name = "PERSON_ID")
    private long personId;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "SURNAME")
    private String surname;
    @Basic
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Basic
    @Column(name = "BIRTHDAY")
    private Time birthday;
    @Basic
    @Column(name = "BIRTHPLACE")
    private String birthplace;
    @Basic
    @Column(name = "PERSON_TYPE")
    private String personType;
    @Basic
    @Column(name = "POSITION")
    private String position;
}
