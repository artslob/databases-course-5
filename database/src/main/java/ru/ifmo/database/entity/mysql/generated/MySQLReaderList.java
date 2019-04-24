package ru.ifmo.database.entity.mysql.generated;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "reader_list", schema = "ifmo_hibd", catalog = "")
public class MySQLReaderList {
    private int listId;
    private Date registrationDate;
    private int personId;
    private Collection<MySQLReaderInfo> readerInfosByListId;
    private MySQLPerson personByPersonId;

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

    @OneToMany(mappedBy = "readerListByReaderId")
    public Collection<MySQLReaderInfo> getReaderInfosByListId() {
        return readerInfosByListId;
    }

    public void setReaderInfosByListId(Collection<MySQLReaderInfo> readerInfosByListId) {
        this.readerInfosByListId = readerInfosByListId;
    }

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)
    public MySQLPerson getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(MySQLPerson personByPersonId) {
        this.personByPersonId = personByPersonId;
    }
}
