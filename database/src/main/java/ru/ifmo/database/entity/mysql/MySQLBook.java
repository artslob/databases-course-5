package ru.ifmo.database.entity.mysql;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "ifmo_hibd", catalog = "")
public class MySQLBook {
    private int bookId;
    private String title;
    private String author;
    private Date publicationDate;

    @Id
    @Column(name = "book_id", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "author", nullable = false, length = 100)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "publication_date", nullable = true)
    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySQLBook mySQLBook = (MySQLBook) o;
        return bookId == mySQLBook.bookId &&
                Objects.equals(title, mySQLBook.title) &&
                Objects.equals(author, mySQLBook.author) &&
                Objects.equals(publicationDate, mySQLBook.publicationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, author, publicationDate);
    }

    @Override
    public String toString() {
        return "MySQLBook{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
