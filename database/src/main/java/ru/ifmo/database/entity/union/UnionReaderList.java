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
@Table(name = "READER_LIST", schema = "IFMO", catalog = "")
public class UnionReaderList {
    @Id
    @Column(name = "LIST_ID")
    private long listId;
    @Basic
    @Column(name = "REGISTRATION_DATE")
    private Time registrationDate;
}
