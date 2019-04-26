package ru.ifmo.database.entity.mysql;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "edition", schema = "ifmo_hibd", catalog = "")
public class MySQLEdition {
    private int editionId;
    private String title;
    private String language;
    private int volume;
    private String place;
    private String type;
    private int publicationId;

    @Id
    @Column(name = "edition_id", nullable = false)
    public int getEditionId() {
        return editionId;
    }

    public void setEditionId(int editionId) {
        this.editionId = editionId;
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
    @Column(name = "language", nullable = false, length = 30)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "volume", nullable = false)
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "place", nullable = false, length = 100)
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "publication_id", nullable = false)
    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySQLEdition that = (MySQLEdition) o;
        return editionId == that.editionId &&
                volume == that.volume &&
                publicationId == that.publicationId &&
                Objects.equals(title, that.title) &&
                Objects.equals(language, that.language) &&
                Objects.equals(place, that.place) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(editionId, title, language, volume, place, type, publicationId);
    }

    @Override
    public String toString() {
        return "MySQLEdition{" +
                "editionId=" + editionId +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", volume=" + volume +
                ", place='" + place + '\'' +
                ", type='" + type + '\'' +
                ", publicationId=" + publicationId +
                '}';
    }
}
