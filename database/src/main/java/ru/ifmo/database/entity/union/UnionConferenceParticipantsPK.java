package ru.ifmo.database.entity.union;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UnionConferenceParticipantsPK implements Serializable {
    private long conferenceId;
    private long personId;

    @Column(name = "CONFERENCE_ID")
    @Id
    public long getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(long conferenceId) {
        this.conferenceId = conferenceId;
    }

    @Column(name = "PERSON_ID")
    @Id
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
        UnionConferenceParticipantsPK that = (UnionConferenceParticipantsPK) o;
        return conferenceId == that.conferenceId &&
                personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conferenceId, personId);
    }
}
