package ru.ifmo.database.entity.oracle;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "SCHEDULE", schema = "IFMO", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OracleSchedule {
    @Id
    @Column(name = "schedule_id")
    private int scheduleId;
    @Size(max = 100)
    private String classroom;
    @Size(max = 200)
    @Column(name = "time_description")
    private String timeDescription;
    @Column(name = "discipline_id")
    private int disciplineId;
}
