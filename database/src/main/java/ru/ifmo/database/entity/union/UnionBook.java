package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "BOOK", schema = "IFMO", catalog = "")
public class UnionBook {
    private long bookId;
    private String title;
    private String author;
    private Time publicationDate;

    @Id
    @Column(name = "BOOK_ID")
    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "PUBLICATION_DATE")
    public Time getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Time publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionBook unionBook = (UnionBook) o;
        return bookId == unionBook.bookId &&
                Objects.equals(title, unionBook.title) &&
                Objects.equals(author, unionBook.author) &&
                Objects.equals(publicationDate, unionBook.publicationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, author, publicationDate);
    }
}
