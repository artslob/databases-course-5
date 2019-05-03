package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "infoId")
@Entity
@Table(name = "READER_INFO")
public class UnionReaderInfo {
    @Id
    @Column(name = "info_id")
    private int infoId;
    @Basic
    @Column(name = "OBTAIN_DATE", nullable = false)
    private Time obtainDate;
    @Basic
    @Column(name = "RETURNED")
    private Time returned;
    @Column(name = "reader_id")
    private int readerId;
    @Column(name = "book_id")
    private int bookId;
}
