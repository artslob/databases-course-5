package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "WORK_DISCIPLINE", schema = "IFMO", catalog = "")
@IdClass(UnionWorkDisciplinePK.class)
public class UnionWorkDiscipline {
    private long workId;
    private long disciplineId;

    @Id
    @Column(name = "WORK_ID")
    public long getWorkId() {
        return workId;
    }

    public void setWorkId(long workId) {
        this.workId = workId;
    }

    @Id
    @Column(name = "DISCIPLINE_ID")
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
        UnionWorkDiscipline that = (UnionWorkDiscipline) o;
        return workId == that.workId &&
                disciplineId == that.disciplineId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(workId, disciplineId);
    }
}
