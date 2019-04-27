package ru.ifmo.database.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Warning {
    private Date date;
    private String text;
}
