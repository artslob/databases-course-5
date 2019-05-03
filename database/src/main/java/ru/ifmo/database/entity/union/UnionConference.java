package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CONFERENCE")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "conferenceId")
public class UnionConference {
    @Id
    @Column(name = "CONFERENCE_ID")
    private int conferenceId;
    @Basic
    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;
    @Basic
    @Column(name = "PLACE", nullable = false, length = 100)
    private String place;
    @Basic
    @Column(name = "CONFERENCE_DATE")
    private Date conferenceDate;
}
