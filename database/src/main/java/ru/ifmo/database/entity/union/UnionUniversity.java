package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UNIVERSITY", schema = "IFMO", catalog = "")
public class UnionUniversity {
    private long universityId;
    private String name;

    @Id
    @Column(name = "UNIVERSITY_ID")
    public long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(long universityId) {
        this.universityId = universityId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionUniversity that = (UnionUniversity) o;
        return universityId == that.universityId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(universityId, name);
    }
}
