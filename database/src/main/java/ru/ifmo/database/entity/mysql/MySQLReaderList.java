package ru.ifmo.database.entity.mysql;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reader_list", schema = "ifmo_hibd", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MySQLReaderList {
    @Id
    @Column(name = "list_id", nullable = false)
    private int listId;
    @Basic
    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;
    @Basic
    @Column(name = "person_id", nullable = false)
    private int personId;
}
