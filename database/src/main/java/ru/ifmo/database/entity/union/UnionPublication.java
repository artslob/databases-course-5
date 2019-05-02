package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PUBLICATION", schema = "IFMO", catalog = "")
public class UnionPublication {
    private long publicationId;
    private String title;
    private String type;
    private Long citationIndex;

    @Id
    @Column(name = "PUBLICATION_ID")
    public long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(long publicationId) {
        this.publicationId = publicationId;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "CITATION_INDEX")
    public Long getCitationIndex() {
        return citationIndex;
    }

    public void setCitationIndex(Long citationIndex) {
        this.citationIndex = citationIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionPublication that = (UnionPublication) o;
        return publicationId == that.publicationId &&
                Objects.equals(title, that.title) &&
                Objects.equals(type, that.type) &&
                Objects.equals(citationIndex, that.citationIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicationId, title, type, citationIndex);
    }
}
