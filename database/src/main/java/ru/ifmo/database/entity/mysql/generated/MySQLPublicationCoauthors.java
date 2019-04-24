package ru.ifmo.database.entity.mysql.generated;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "publication_coauthors", schema = "ifmo_hibd", catalog = "")
@IdClass(MySQLPublicationCoauthorsPK.class)
public class MySQLPublicationCoauthors {
    private int publicationId;
    private int personId;
    private MySQLPublication publicationByPublicationId;
    private MySQLPerson personByPersonId;

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

    @ManyToOne
    @JoinColumn(name = "publication_id", referencedColumnName = "publication_id", nullable = false)
    public MySQLPublication getPublicationByPublicationId() {
        return publicationByPublicationId;
    }

    public void setPublicationByPublicationId(MySQLPublication publicationByPublicationId) {
        this.publicationByPublicationId = publicationByPublicationId;
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
