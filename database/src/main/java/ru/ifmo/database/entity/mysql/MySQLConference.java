package ru.ifmo.database.entity.mysql;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "conference", schema = "ifmo_hibd", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MySQLConference {
    @Id
    @Column(name = "conference_id", nullable = false)
    private int conferenceId;
    @Basic
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Basic
    @Column(name = "place", nullable = false, length = 100)
    private String place;
    @Basic
    @Column(name = "conference_date", nullable = false)
    private Date conferenceDate;
}
