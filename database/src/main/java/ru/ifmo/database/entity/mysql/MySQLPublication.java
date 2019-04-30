package ru.ifmo.database.entity.mysql;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "publication", schema = "ifmo_hibd", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MySQLPublication {
    @Id
    @Column(name = "publication_id", nullable = false)
    private int publicationId;
    @Basic
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Basic
    @Column(name = "type", nullable = true)
    private String type;
    @Basic
    @Column(name = "citation_index", nullable = true)
    private Integer citationIndex;
}
