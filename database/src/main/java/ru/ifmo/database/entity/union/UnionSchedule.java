package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SCHEDULE", schema = "IFMO", catalog = "")
public class UnionSchedule {
    private long scheduleId;
    private String classroom;
    private String timeDescription;

    @Id
    @Column(name = "SCHEDULE_ID")
    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Basic
    @Column(name = "CLASSROOM")
    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Basic
    @Column(name = "TIME_DESCRIPTION")
    public String getTimeDescription() {
        return timeDescription;
    }

    public void setTimeDescription(String timeDescription) {
        this.timeDescription = timeDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionSchedule that = (UnionSchedule) o;
        return scheduleId == that.scheduleId &&
                Objects.equals(classroom, that.classroom) &&
                Objects.equals(timeDescription, that.timeDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId, classroom, timeDescription);
    }
}
