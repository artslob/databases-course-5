package ru.ifmo.database.entity.mysql;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "book", schema = "ifmo_hibd", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MySQLBook {
    @Id
    @Column(name = "book_id", nullable = false)
    private int bookId;
    @Basic
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Basic
    @Column(name = "author", nullable = false, length = 100)
    private String author;
    @Basic
    @Column(name = "publication_date", nullable = true)
    private Date publicationDate;
}
