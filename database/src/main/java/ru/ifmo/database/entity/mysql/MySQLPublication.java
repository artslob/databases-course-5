package ru.ifmo.database.entity.mysql;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "publication", schema = "ifmo_hibd", catalog = "")
public class MySQLPublication {
    private int publicationId;
    private String title;
    private String type;
    private Integer citationIndex;

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
    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    @Override
    public String toString() {
        return "MySQLPublication{" +
                "publicationId=" + publicationId +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", citationIndex=" + citationIndex +
                '}';
    }
}
