package ru.ifmo.database.entity.mysql.generated;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "person", schema = "ifmo_hibd", catalog = "")
public class MySQLPerson {
    private int personId;
    private String name;
    private String surname;
    private String middleName;
    private Object position;
    private Collection<MySQLConferenceParticipants> conferenceParticipantsByPersonId;
    private Collection<MySQLProjectParticipants> projectParticipantsByPersonId;
    private Collection<MySQLPublicationCoauthors> publicationCoauthorsByPersonId;
    private Collection<MySQLReaderList> readerListsByPersonId;

    @Id
    @Column(name = "person_id", nullable = false)
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 20)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "middle_name", nullable = true, length = 20)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "position", nullable = false)
    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySQLPerson that = (MySQLPerson) o;
        return personId == that.personId &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, name, surname, middleName, position);
    }

    @OneToMany(mappedBy = "personByPersonId")
    public Collection<MySQLConferenceParticipants> getConferenceParticipantsByPersonId() {
        return conferenceParticipantsByPersonId;
    }

    public void setConferenceParticipantsByPersonId(Collection<MySQLConferenceParticipants> conferenceParticipantsByPersonId) {
        this.conferenceParticipantsByPersonId = conferenceParticipantsByPersonId;
    }

    @OneToMany(mappedBy = "personByPersonId")
    public Collection<MySQLProjectParticipants> getProjectParticipantsByPersonId() {
        return projectParticipantsByPersonId;
    }

    public void setProjectParticipantsByPersonId(Collection<MySQLProjectParticipants> projectParticipantsByPersonId) {
        this.projectParticipantsByPersonId = projectParticipantsByPersonId;
    }

    @OneToMany(mappedBy = "personByPersonId")
    public Collection<MySQLPublicationCoauthors> getPublicationCoauthorsByPersonId() {
        return publicationCoauthorsByPersonId;
    }

    public void setPublicationCoauthorsByPersonId(Collection<MySQLPublicationCoauthors> publicationCoauthorsByPersonId) {
        this.publicationCoauthorsByPersonId = publicationCoauthorsByPersonId;
    }

    @OneToMany(mappedBy = "personByPersonId")
    public Collection<MySQLReaderList> getReaderListsByPersonId() {
        return readerListsByPersonId;
    }

    public void setReaderListsByPersonId(Collection<MySQLReaderList> readerListsByPersonId) {
        this.readerListsByPersonId = readerListsByPersonId;
    }
}
