package ru.ifmo.database.entity.mysql;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "edition", schema = "ifmo_hibd", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MySQLEdition {
    @Id
    @Column(name = "edition_id", nullable = false)
    private int editionId;
    @Basic
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Basic
    @Column(name = "language", nullable = false, length = 30)
    private String language;
    @Basic
    @Column(name = "volume", nullable = false)
    private int volume;
    @Basic
    @Column(name = "place", nullable = false, length = 100)
    private String place;
    @Basic
    @Column(name = "type", nullable = false, length = 50)
    private String type;
    @Basic
    @Column(name = "publication_id", nullable = false)
    private int publicationId;
}
