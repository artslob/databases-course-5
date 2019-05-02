package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "BOOK", schema = "IFMO", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UnionBook {
    @Id
    @Column(name = "BOOK_ID")
    private long bookId;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "AUTHOR")
    private String author;
    @Basic
    @Column(name = "PUBLICATION_DATE")
    private Time publicationDate;
}
