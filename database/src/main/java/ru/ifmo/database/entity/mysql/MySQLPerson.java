package ru.ifmo.database.entity.mysql;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MySQLPerson {

    @Id
    @Column(name = "person_id")
    private int id;
    private String name;
    private String surname;
    @Column(name = "middle_name")
    private String middleName;
    private String position;
}
