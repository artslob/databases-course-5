package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UnionProjectParticipantsPK implements Serializable {
    @Column(name = "PROJECT_ID")
    @Id
    private int projectId;
    @Column(name = "PERSON_ID")
    @Id
    private int personId;
}
