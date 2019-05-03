package ru.ifmo.database.etl.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExtractData<P, MS, O, M> {
    private List<P> postgresEntityList;
    private List<MS> mySQLEntityList;
    private List<O> oracleEntityList;
    private List<M> mongoEntityList;
}
