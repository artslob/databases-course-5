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
public class UnionConferenceParticipantsPK implements Serializable {
    @Column(name = "CONFERENCE_ID")
    @Id
    private long conferenceId;
    @Column(name = "PERSON_ID")
    @Id
    private long personId;
}
