package ru.ifmo.database.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@ToString
public class Disinfection {
    @Field("disinfection_id")
    private int disinfectionId;
    private Date date;
}
