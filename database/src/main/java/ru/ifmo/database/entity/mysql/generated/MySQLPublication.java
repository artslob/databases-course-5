package ru.ifmo.database.entity.mysql.generated;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "publication", schema = "ifmo_hibd", catalog = "")
public class MySQLPublication {
    private int publicationId;
    private String title;
    private Object type;
    private Integer citationIndex;
    private Collection<MySQLEdition> editionsByPublicationId;
    private Collection<MySQLPublicationCoauthors> publicationCoauthorsByPublicationId;

    @Id
    @Column(name = "publication_id", nullable = false)
    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    @Basic
    @Column(name = "citation_index", nullable = true)
    public Integer getCitationIndex() {
        return citationIndex;
    }

    public void setCitationIndex(Integer citationIndex) {
        this.citationIndex = citationIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySQLPublication that = (MySQLPublication) o;
        return publicationId == that.publicationId &&
                Objects.equals(title, that.title) &&
                Objects.equals(type, that.type) &&
                Objects.equals(citationIndex, that.citationIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicationId, title, type, citationIndex);
    }

    @OneToMany(mappedBy = "publicationByPublicationId")
    public Collection<MySQLEdition> getEditionsByPublicationId() {
        return editionsByPublicationId;
    }

    public void setEditionsByPublicationId(Collection<MySQLEdition> editionsByPublicationId) {
        this.editionsByPublicationId = editionsByPublicationId;
    }

    @OneToMany(mappedBy = "publicationByPublicationId")
    public Collection<MySQLPublicationCoauthors> getPublicationCoauthorsByPublicationId() {
        return publicationCoauthorsByPublicationId;
    }

    public void setPublicationCoauthorsByPublicationId(Collection<MySQLPublicationCoauthors> publicationCoauthorsByPublicationId) {
        this.publicationCoauthorsByPublicationId = publicationCoauthorsByPublicationId;
    }
}
