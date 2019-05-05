package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BOOK")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "bookId")
public class UnionBook {
    @Id
    @Column(name = "BOOK_ID")
    private int bookId;
    @Basic
    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;
    @Basic
    @Column(name = "AUTHOR", nullable = false, length = 100)
    private String author;
    @Basic
    @Column(name = "PUBLICATION_DATE")
    private Date publicationDate;
}
