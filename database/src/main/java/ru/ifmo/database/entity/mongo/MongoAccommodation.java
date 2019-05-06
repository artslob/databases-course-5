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
import java.util.List;

@Document(collection = "accommodation")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MongoAccommodation {
    @Id
    @JsonIgnore
    private String id;
    @Field("id")
    private int accommodationId;
    @Field("person_id")
    private int personId;
    @Field("room_id")
    private int roomId;
    private Date from;
    private Date to;
    private Boolean exemption;
    private List<Warning> warnings;
}
