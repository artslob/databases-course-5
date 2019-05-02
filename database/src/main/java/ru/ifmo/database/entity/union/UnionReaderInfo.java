package ru.ifmo.database.entity.union;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "READER_INFO", schema = "IFMO", catalog = "")
public class UnionReaderInfo {
    private Time obtainDate;
    private Time returned;

    @Basic
    @Column(name = "OBTAIN_DATE")
    public Time getObtainDate() {
        return obtainDate;
    }

    public void setObtainDate(Time obtainDate) {
        this.obtainDate = obtainDate;
    }

    @Basic
    @Column(name = "RETURNED")
    public Time getReturned() {
        return returned;
    }

    public void setReturned(Time returned) {
        this.returned = returned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionReaderInfo that = (UnionReaderInfo) o;
        return Objects.equals(obtainDate, that.obtainDate) &&
                Objects.equals(returned, that.returned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(obtainDate, returned);
    }
}
