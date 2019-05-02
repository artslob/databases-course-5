package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SPECIALITY", schema = "IFMO", catalog = "")
public class UnionSpeciality {
    private long specialityId;
    private String name;
    private String direction;
    private String standard;

    @Id
    @Column(name = "SPECIALITY_ID")
    public long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(long specialityId) {
        this.specialityId = specialityId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DIRECTION")
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Basic
    @Column(name = "STANDARD")
    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionSpeciality that = (UnionSpeciality) o;
        return specialityId == that.specialityId &&
                Objects.equals(name, that.name) &&
                Objects.equals(direction, that.direction) &&
                Objects.equals(standard, that.standard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialityId, name, direction, standard);
    }
}
