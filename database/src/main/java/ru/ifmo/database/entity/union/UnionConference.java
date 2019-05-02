package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "CONFERENCE", schema = "IFMO", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UnionConference {
    @Id
    @Column(name = "CONFERENCE_ID")
    private long conferenceId;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "PLACE")
    private String place;
    @Basic
    @Column(name = "CONFERENCE_DATE")
    private Time conferenceDate;
}
