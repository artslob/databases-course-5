package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CONFERENCE_PARTICIPANTS", schema = "IFMO", catalog = "")
@IdClass(UnionConferenceParticipantsPK.class)
public class UnionConferenceParticipants {
    private long conferenceId;
    private long personId;

    @Id
    @Column(name = "CONFERENCE_ID")
    public long getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(long conferenceId) {
        this.conferenceId = conferenceId;
    }

    @Id
    @Column(name = "PERSON_ID")
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionConferenceParticipants that = (UnionConferenceParticipants) o;
        return conferenceId == that.conferenceId &&
                personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conferenceId, personId);
    }
}
