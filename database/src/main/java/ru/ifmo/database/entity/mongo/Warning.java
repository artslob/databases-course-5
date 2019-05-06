package ru.ifmo.database.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@ToString
public class Warning {
    @Field("warning_id")
    private int warningId;
    private Date date;
    private String text;
}
