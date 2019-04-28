package ru.ifmo.database.entity.mysql;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reader_info", schema = "ifmo_hibd", catalog = "")
public class MySQLReaderInfo {
    private int infoId;
    private int readerId;
    private int bookId;
    private Date obtainDate;
    private Date returned;

    @Id
    @Column(name = "info_id", nullable = false)
    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    @Basic
    @Column(name = "reader_id", nullable = false)
    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    @Basic
    @Column(name = "book_id", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "obtain_date", nullable = false)
    public Date getObtainDate() {
        return obtainDate;
    }

    public void setObtainDate(Date obtainDate) {
        this.obtainDate = obtainDate;
    }

    @Basic
    @Column(name = "returned", nullable = true)
    public Date getReturned() {
        return returned;
    }

    public void setReturned(Date returned) {
        this.returned = returned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySQLReaderInfo that = (MySQLReaderInfo) o;
        return readerId == that.readerId &&
                bookId == that.bookId &&
                Objects.equals(obtainDate, that.obtainDate) &&
                Objects.equals(returned, that.returned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readerId, bookId, obtainDate, returned);
    }

    @Override
    public String toString() {
        return "MySQLReaderInfo{" +
                "infoId=" + infoId +
                ", readerId=" + readerId +
                ", bookId=" + bookId +
                ", obtainDate=" + obtainDate +
                ", returned=" + returned +
                '}';
    }
}