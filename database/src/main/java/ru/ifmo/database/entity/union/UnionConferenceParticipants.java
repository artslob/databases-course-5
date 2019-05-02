package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "CONFERENCE_PARTICIPANTS", schema = "IFMO", catalog = "")
@IdClass(UnionConferenceParticipantsPK.class)
public class UnionConferenceParticipants {
    @Id
    @Column(name = "CONFERENCE_ID")
    private long conferenceId;
    @Id
    @Column(name = "PERSON_ID")
    private long personId;
}
