package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "publicationId")
@Entity
@Table(name = "PUBLICATION", schema = "IFMO", catalog = "")
public class UnionPublication {
    @Id
    @Column(name = "PUBLICATION_ID")
    private int publicationId;
    @Basic
    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;
    @Basic
    @Column(name = "TYPE", nullable = false, length = 20)
    private String type;
    @Basic
    @Column(name = "CITATION_INDEX")
    private int citationIndex;
}
