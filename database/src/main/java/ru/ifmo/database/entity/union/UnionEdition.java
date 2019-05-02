package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "EDITION", schema = "IFMO", catalog = "")
public class UnionEdition {
    @Id
    @Column(name = "EDITION_ID")
    private long editionId;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "LANGUAGE")
    private String language;
    @Basic
    @Column(name = "VOLUME")
    private long volume;
    @Basic
    @Column(name = "PLACE")
    private String place;
    @Basic
    @Column(name = "TYPE")
    private String type;
}
