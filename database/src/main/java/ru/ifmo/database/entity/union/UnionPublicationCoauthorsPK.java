package ru.ifmo.database.entity.union;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UnionPublicationCoauthorsPK implements Serializable {
    private long publicationId;
    private long personId;

    @Column(name = "PUBLICATION_ID")
    @Id
    public long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(long publicationId) {
        this.publicationId = publicationId;
    }

    @Column(name = "PERSON_ID")
    @Id
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionPublicationCoauthorsPK that = (UnionPublicationCoauthorsPK) o;
        return publicationId == that.publicationId &&
                personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicationId, personId);
    }
}
