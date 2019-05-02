package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "PUBLICATION", schema = "IFMO", catalog = "")
public class UnionPublication {
    @Id
    @Column(name = "PUBLICATION_ID")
    private long publicationId;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "TYPE")
    private String type;
    @Basic
    @Column(name = "CITATION_INDEX")
    private Long citationIndex;
}
