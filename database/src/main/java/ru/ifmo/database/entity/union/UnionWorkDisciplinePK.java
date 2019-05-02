package ru.ifmo.database.entity.union;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UnionWorkDisciplinePK implements Serializable {
    private long workId;
    private long disciplineId;

    @Column(name = "WORK_ID")
    @Id
    public long getWorkId() {
        return workId;
    }

    public void setWorkId(long workId) {
        this.workId = workId;
    }

    @Column(name = "DISCIPLINE_ID")
    @Id
    public long getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(long disciplineId) {
        this.disciplineId = disciplineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionWorkDisciplinePK that = (UnionWorkDisciplinePK) o;
        return workId == that.workId &&
                disciplineId == that.disciplineId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(workId, disciplineId);
    }
}
