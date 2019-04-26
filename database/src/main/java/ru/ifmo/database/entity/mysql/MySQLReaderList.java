package ru.ifmo.database.entity.mysql;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reader_list", schema = "ifmo_hibd", catalog = "")
public class MySQLReaderList {
    private int listId;
    private Date registrationDate;
    private int personId;

    @Id
    @Column(name = "list_id", nullable = false)
    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    @Basic
    @Column(name = "registration_date", nullable = false)
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Basic
    @Column(name = "person_id", nullable = false)
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySQLReaderList that = (MySQLReaderList) o;
        return listId == that.listId &&
                personId == that.personId &&
                Objects.equals(registrationDate, that.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listId, registrationDate, personId);
    }

    @Override
    public String toString() {
        return "MySQLReaderList{" +
                "listId=" + listId +
                ", registrationDate=" + registrationDate +
                ", personId=" + personId +
                '}';
    }
}
