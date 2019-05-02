package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PUBLICATION_COAUTHORS", schema = "IFMO", catalog = "")
@IdClass(UnionPublicationCoauthorsPK.class)
public class UnionPublicationCoauthors {
    private long publicationId;
    private long personId;

    @Id
    @Column(name = "PUBLICATION_ID")
    public long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(long publicationId) {
        this.publicationId = publicationId;
    }

    @Id
    @Column(name = "PERSON_ID")
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
        UnionPublicationCoauthors that = (UnionPublicationCoauthors) o;
        return publicationId == that.publicationId &&
                personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicationId, personId);
    }
}
