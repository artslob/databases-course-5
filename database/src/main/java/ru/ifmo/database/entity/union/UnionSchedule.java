package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "SCHEDULE")
public class UnionSchedule {
    @Id
    @Column(name = "SCHEDULE_ID")
    private int scheduleId;
    @Basic
    @Column(name = "CLASSROOM", length = 100)
    private String classroom;
    @Basic
    @Column(name = "TIME_DESCRIPTION", length = 200)
    private String timeDescription;
    @Column(name = "discipline_id")
    private int disciplineId;
}
