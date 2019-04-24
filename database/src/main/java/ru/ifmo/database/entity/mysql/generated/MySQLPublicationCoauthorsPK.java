package ru.ifmo.database.entity.mysql.generated;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MySQLPublicationCoauthorsPK implements Serializable {
    private int publicationId;
    private int personId;

    @Column(name = "publication_id", nullable = false)
    @Id
    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    @Column(name = "person_id", nullable = false)
    @Id
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
        MySQLPublicationCoauthorsPK that = (MySQLPublicationCoauthorsPK) o;
        return publicationId == that.publicationId &&
                personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicationId, personId);
    }
}
