package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "PUBLICATION_COAUTHORS", schema = "IFMO", catalog = "")
@IdClass(UnionPublicationCoauthorsPK.class)
public class UnionPublicationCoauthors {
    @Id
    @Column(name = "PUBLICATION_ID")
    private long publicationId;
    @Id
    @Column(name = "PERSON_ID")
    private long personId;
}
