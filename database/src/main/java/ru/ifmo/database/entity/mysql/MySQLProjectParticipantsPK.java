package ru.ifmo.database.entity.mysql;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MySQLProjectParticipantsPK implements Serializable {
    @Id
    @Column(name = "project_id", nullable = false)
    private int projectId;
    @Id
    @Column(name = "person_id", nullable = false)
    private int personId;
}
