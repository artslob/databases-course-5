package ru.ifmo.database.entity.mysql;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "project_participants", schema = "ifmo_hibd", catalog = "")
@IdClass(MySQLProjectParticipantsPK.class)
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MySQLProjectParticipants {
    @Id
    @Column(name = "project_id", nullable = false)
    private int projectId;
    @Id
    @Column(name = "person_id", nullable = false)
    private int personId;
}
