package ru.ifmo.database.entity.mysql;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MySQLConferenceParticipantsPK implements Serializable {
    private int conferenceId;
    private int personId;

    @Column(name = "conference_id", nullable = false)
    @Id
    public int getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }

    @Column(name = "person_id", nullable = false)
    @Id
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
        MySQLConferenceParticipantsPK that = (MySQLConferenceParticipantsPK) o;
        return conferenceId == that.conferenceId &&
                personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conferenceId, personId);
    }
}
