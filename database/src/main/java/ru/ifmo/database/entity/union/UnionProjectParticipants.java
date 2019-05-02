package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "PROJECT_PARTICIPANTS", schema = "IFMO", catalog = "")
@IdClass(UnionProjectParticipantsPK.class)
public class UnionProjectParticipants {
    @Id
    @Column(name = "PROJECT_ID")
    private long projectId;
    @Id
    @Column(name = "PERSON_ID")
    private long personId;
}
