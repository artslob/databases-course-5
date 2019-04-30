package ru.ifmo.database.entity.mysql;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reader_info", schema = "ifmo_hibd", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MySQLReaderInfo {
    @Id
    @Column(name = "info_id", nullable = false)
    private int infoId;
    @Basic
    @Column(name = "reader_id", nullable = false)
    private int readerId;
    @Basic
    @Column(name = "book_id", nullable = false)
    private int bookId;
    @Basic
    @Column(name = "obtain_date", nullable = false)
    private Date obtainDate;
    @Basic
    @Column(name = "returned", nullable = true)
    private Date returned;
}
