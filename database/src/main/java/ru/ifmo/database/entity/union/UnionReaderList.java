package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "READER_LIST", schema = "IFMO", catalog = "")
public class UnionReaderList {
    private long listId;
    private Time registrationDate;

    @Id
    @Column(name = "LIST_ID")
    public long getListId() {
        return listId;
    }

    public void setListId(long listId) {
        this.listId = listId;
    }

    @Basic
    @Column(name = "REGISTRATION_DATE")
    public Time getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Time registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionReaderList that = (UnionReaderList) o;
        return listId == that.listId &&
                Objects.equals(registrationDate, that.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listId, registrationDate);
    }
}
