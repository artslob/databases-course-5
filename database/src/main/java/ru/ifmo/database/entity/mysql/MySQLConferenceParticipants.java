package ru.ifmo.database.entity.mysql;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "conference_participants", schema = "ifmo_hibd", catalog = "")
@IdClass(MySQLConferenceParticipantsPK.class)
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MySQLConferenceParticipants {
    @Id
    @Column(name = "conference_id", nullable = false)
    private int conferenceId;
    @Id
    @Column(name = "person_id", nullable = false)
    private int personId;
}
