package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "WORK", schema = "IFMO", catalog = "")
public class UnionWork {
    private long workId;
    private String position;
    private Time workStart;
    private Time workEnd;

    @Id
    @Column(name = "WORK_ID")
    public long getWorkId() {
        return workId;
    }

    public void setWorkId(long workId) {
        this.workId = workId;
    }

    @Basic
    @Column(name = "POSITION")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "WORK_START")
    public Time getWorkStart() {
        return workStart;
    }

    public void setWorkStart(Time workStart) {
        this.workStart = workStart;
    }

    @Basic
    @Column(name = "WORK_END")
    public Time getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(Time workEnd) {
        this.workEnd = workEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionWork unionWork = (UnionWork) o;
        return workId == unionWork.workId &&
                Objects.equals(position, unionWork.position) &&
                Objects.equals(workStart, unionWork.workStart) &&
                Objects.equals(workEnd, unionWork.workEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workId, position, workStart, workEnd);
    }
}
