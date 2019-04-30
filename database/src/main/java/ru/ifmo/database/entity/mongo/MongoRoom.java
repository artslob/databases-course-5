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

@Document(collection = "room")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MongoRoom {
    @Id
    @JsonIgnore
    private String id;
    @Field("id")
    private int roomId;
    @Field("hostel_id")
    private int hostelId;
    @Field("room_number")
    private int roomNumber;
    private int capacity;
    private int payment;
    private Boolean insects;
    private List<Date> disinfection;
}
