package ru.ifmo.database.entity.postgres;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "university", schema = "public", catalog = "ifmo_hibd")
public class PostgresUniversity {
    private int universityId;
    private String name;

    @Id
    @Column(name = "university_id", nullable = false)
    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
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
        PostgresUniversity that = (PostgresUniversity) o;
        return universityId == that.universityId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(universityId, name);
    }

    @Override
    public String toString() {
        return "PostgresUniversity{" +
                "universityId=" + universityId +
                ", name='" + name + '\'' +
                '}';
    }
}
