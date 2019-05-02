package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "VISIT", schema = "IFMO", catalog = "")
public class UnionVisit {
    private long visitId;
    private Time inside;
    private Time outside;

    @Id
    @Column(name = "VISIT_ID")
    public long getVisitId() {
        return visitId;
    }

    public void setVisitId(long visitId) {
        this.visitId = visitId;
    }

    @Basic
    @Column(name = "INSIDE")
    public Time getInside() {
        return inside;
    }

    public void setInside(Time inside) {
        this.inside = inside;
    }

    @Basic
    @Column(name = "OUTSIDE")
    public Time getOutside() {
        return outside;
    }

    public void setOutside(Time outside) {
        this.outside = outside;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionVisit that = (UnionVisit) o;
        return visitId == that.visitId &&
                Objects.equals(inside, that.inside) &&
                Objects.equals(outside, that.outside);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitId, inside, outside);
    }
}
