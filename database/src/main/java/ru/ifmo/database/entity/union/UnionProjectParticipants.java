package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROJECT_PARTICIPANTS", schema = "IFMO", catalog = "")
@IdClass(UnionProjectParticipantsPK.class)
public class UnionProjectParticipants {
    private long projectId;
    private long personId;

    @Id
    @Column(name = "PROJECT_ID")
    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
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
        UnionProjectParticipants that = (UnionProjectParticipants) o;
        return projectId == that.projectId &&
                personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, personId);
    }
}
