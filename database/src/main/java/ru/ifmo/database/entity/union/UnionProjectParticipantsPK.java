package ru.ifmo.database.entity.union;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UnionProjectParticipantsPK implements Serializable {
    private long projectId;
    private long personId;

    @Column(name = "PROJECT_ID")
    @Id
    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
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
        UnionProjectParticipantsPK that = (UnionProjectParticipantsPK) o;
        return projectId == that.projectId &&
                personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, personId);
    }
}
