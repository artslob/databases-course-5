package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "SCHEDULE", schema = "IFMO", catalog = "")
public class UnionSchedule {
    @Id
    @Column(name = "SCHEDULE_ID")
    private long scheduleId;
    @Basic
    @Column(name = "CLASSROOM")
    private String classroom;
    @Basic
    @Column(name = "TIME_DESCRIPTION")
    private String timeDescription;
}
