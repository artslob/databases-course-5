package ru.ifmo.database.entity.mysql;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "conference_participants", schema = "ifmo_hibd", catalog = "")
@IdClass(MySQLConferenceParticipantsPK.class)
public class MySQLConferenceParticipants {
    private int conferenceId;
    private int personId;

    @Id
    @Column(name = "conference_id", nullable = false)
    public int getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }

    @Id
    @Column(name = "person_id", nullable = false)
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySQLConferenceParticipants that = (MySQLConferenceParticipants) o;
        return conferenceId == that.conferenceId &&
                personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conferenceId, personId);
    }

    @Override
    public String toString() {
        return "MySQLConferenceParticipants{" +
                "conferenceId=" + conferenceId +
                ", personId=" + personId +
                '}';
    }
}
