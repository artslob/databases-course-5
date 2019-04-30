package ru.ifmo.database.entity.mysql;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MySQLConferenceParticipantsPK implements Serializable {
    @Id
    @Column(name = "conference_id", nullable = false)
    private int conferenceId;
    @Id
    @Column(name = "person_id", nullable = false)
    private int personId;
}
