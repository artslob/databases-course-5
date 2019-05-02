package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "ACCOMMODATION", schema = "IFMO", catalog = "")
public class UnionAccommodation {
    private long accommodationId;
    private Time accFrom;
    private Time accTo;
    private long exemption;

    @Id
    @Column(name = "ACCOMMODATION_ID")
    public long getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(long accommodationId) {
        this.accommodationId = accommodationId;
    }

    @Basic
    @Column(name = "ACC_FROM")
    public Time getAccFrom() {
        return accFrom;
    }

    public void setAccFrom(Time accFrom) {
        this.accFrom = accFrom;
    }

    @Basic
    @Column(name = "ACC_TO")
    public Time getAccTo() {
        return accTo;
    }

    public void setAccTo(Time accTo) {
        this.accTo = accTo;
    }

    @Basic
    @Column(name = "EXEMPTION")
    public long getExemption() {
        return exemption;
    }

    public void setExemption(long exemption) {
        this.exemption = exemption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionAccommodation that = (UnionAccommodation) o;
        return accommodationId == that.accommodationId &&
                exemption == that.exemption &&
                Objects.equals(accFrom, that.accFrom) &&
                Objects.equals(accTo, that.accTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accommodationId, accFrom, accTo, exemption);
    }
}
