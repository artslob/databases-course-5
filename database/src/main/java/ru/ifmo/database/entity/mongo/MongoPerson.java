package ru.ifmo.database.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

@Document(collection = "person")
@Getter
@Setter
public class MongoPerson {
    @Id
    private String id;
    @Field("id")
    private int personId;
    private String name;
    private String surname;
    @Field(value = "middle_name")
    private String middleName;
    @Field(value = "study_type")
    private String studyType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MongoPerson)) return false;
        MongoPerson that = (MongoPerson) o;
        return personId == that.personId &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(studyType, that.studyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, name, surname, middleName, studyType);
    }

    @Override
    public String toString() {
        return "MongoPerson{" +
                "id=" + personId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", studyType='" + studyType + '\'' +
                '}';
    }
}
