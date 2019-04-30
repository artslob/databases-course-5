package ru.ifmo.database.entity.mysql;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "publication_coauthors", schema = "ifmo_hibd", catalog = "")
@IdClass(MySQLPublicationCoauthorsPK.class)
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MySQLPublicationCoauthors {
    @Id
    @Column(name = "publication_id", nullable = false)
    private int publicationId;
    @Id
    @Column(name = "person_id", nullable = false)
    private int personId;
}
