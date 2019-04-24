package ru.ifmo.database.entity.mysql.generated;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "project_participants", schema = "ifmo_hibd", catalog = "")
@IdClass(MySQLProjectParticipantsPK.class)
public class MySQLProjectParticipants {
    private int projectId;
    private int personId;
    private MySQLProject projectByProjectId;
    private MySQLPerson personByPersonId;

    @Id
    @Column(name = "project_id", nullable = false)
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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
        MySQLProjectParticipants that = (MySQLProjectParticipants) o;
        return projectId == that.projectId &&
                personId == that.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, personId);
    }

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false)
    public MySQLProject getProjectByProjectId() {
        return projectByProjectId;
    }

    public void setProjectByProjectId(MySQLProject projectByProjectId) {
        this.projectByProjectId = projectByProjectId;
    }

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)
    public MySQLPerson getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(MySQLPerson personByPersonId) {
        this.personByPersonId = personByPersonId;
    }
}
