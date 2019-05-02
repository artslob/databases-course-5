package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UnionPublicationCoauthorsPK implements Serializable {
    @Column(name = "PUBLICATION_ID")
    @Id
    private long publicationId;
    @Column(name = "PERSON_ID")
    @Id
    private long personId;
}
