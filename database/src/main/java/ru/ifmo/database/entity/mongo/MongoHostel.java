package ru.ifmo.database.entity.mongo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "hostel")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MongoHostel {
    @Id
    @JsonIgnore
    private String id;
    @Field("id")
    private int hostelId;
    private String address;
    private int rooms;
}
