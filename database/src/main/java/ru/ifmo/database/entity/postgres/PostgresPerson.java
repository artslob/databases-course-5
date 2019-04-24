package ru.ifmo.database.entity.postgres;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "person", schema = "public", catalog = "ifmo_hibd")
public class PostgresPerson {
    private int personId;
    private String name;
    private String surname;
    private String middleName;
    private String personType;
    private PostgresDepartment departmentByDepartmentId;

    @Id
    @Column(name = "person_id", nullable = false)
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 20)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "middle_name", nullable = true, length = 20)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "person_type", nullable = false)
    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostgresPerson that = (PostgresPerson) o;
        return personId == that.personId &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(personType, that.personType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, name, surname, middleName, personType);
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    public PostgresDepartment getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(PostgresDepartment departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }

    @Override
    public String toString() {
        return "PostgresPerson{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", personType='" + personType + '\'' +
                ", departmentByDepartmentId=" + departmentByDepartmentId +
                '}';
    }
}
