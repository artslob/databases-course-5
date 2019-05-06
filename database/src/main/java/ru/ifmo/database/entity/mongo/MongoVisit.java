package ru.ifmo.database.entity.mongo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "visit")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MongoVisit {
    @Id
    @JsonIgnore
    private String id;
    @Field("id")
    private int visitId;
    @Field("person_id")
    private int personId;
    @Field("hostel_id")
    private int hostelId;
    private Date inside;
    private Date outside;
}
