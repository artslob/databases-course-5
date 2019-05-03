package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "editionId")
@Entity
@Table(name = "EDITION")
public class UnionEdition {
    @Id
    @Column(name = "EDITION_ID")
    private int editionId;
    @Basic
    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;
    @Basic
    @Column(name = "LANGUAGE", nullable = false, length = 30)
    private String language;
    @Basic
    @Column(name = "VOLUME", nullable = false)
    private int volume;
    @Basic
    @Column(name = "PLACE", nullable = false, length = 100)
    private String place;
    @Basic
    @Column(name = "TYPE", nullable = false, length = 100)
    private String type;
    @Column(name = "publication_id")
    private int publicationId;
}
