package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "listId")
@Entity
@Table(name = "READER_LIST", schema = "IFMO", catalog = "")
public class UnionReaderList {
    @Id
    @Column(name = "LIST_ID")
    private int listId;
    @Basic
    @Column(name = "REGISTRATION_DATE", nullable = false)
    private Date registrationDate;
    @Column(name = "person_id")
    private int personId;
}
