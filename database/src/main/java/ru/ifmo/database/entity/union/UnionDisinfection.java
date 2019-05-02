package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "DISINFECTION", schema = "IFMO", catalog = "")
public class UnionDisinfection {
    private long disinfectionId;
    private Time disinfectionDate;

    @Id
    @Column(name = "DISINFECTION_ID")
    public long getDisinfectionId() {
        return disinfectionId;
    }

    public void setDisinfectionId(long disinfectionId) {
        this.disinfectionId = disinfectionId;
    }

    @Basic
    @Column(name = "DISINFECTION_DATE")
    public Time getDisinfectionDate() {
        return disinfectionDate;
    }

    public void setDisinfectionDate(Time disinfectionDate) {
        this.disinfectionDate = disinfectionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionDisinfection that = (UnionDisinfection) o;
        return disinfectionId == that.disinfectionId &&
                Objects.equals(disinfectionDate, that.disinfectionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disinfectionId, disinfectionDate);
    }
}
