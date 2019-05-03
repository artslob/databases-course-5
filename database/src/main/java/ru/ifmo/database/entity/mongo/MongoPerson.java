package ru.ifmo.database.entity.mongo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "person")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "personId")
public class MongoPerson {
    @Id
    @JsonIgnore
    private String id;
    @Field("id")
    private int personId;
    private String name;
    private String surname;
    @Field(value = "middle_name")
    private String middleName;
}
