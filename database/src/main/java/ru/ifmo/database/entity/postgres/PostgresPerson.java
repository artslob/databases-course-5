package ru.ifmo.database.entity.postgres;

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
public class PostgresPerson {

    @Id
    @Column(name = "person_id")
    private int id;
    private String name;
    private String surname;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "person_type")
    private String personType;
    @Column(name = "speciality_id")
    private int specialityId;
}
