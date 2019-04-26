package ru.ifmo.database.entity.mysql;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "publication_coauthors", schema = "ifmo_hibd", catalog = "")
@IdClass(MySQLPublicationCoauthorsPK.class)
public class MySQLPublicationCoauthors {
    private int publicationId;
    private int personId;

    @Id
    @Column(name = "publication_id", nullable = false)
    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    @Id
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
        MySQLPublicationCoauthors that = (MySQLPublicationCoauthors) o;
        return publicationId == that.publicationId &&
                personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicationId, personId);
    }

    @Override
    public String toString() {
        return "MySQLPublicationCoauthors{" +
                "publicationId=" + publicationId +
                ", personId=" + personId +
                '}';
    }
}
