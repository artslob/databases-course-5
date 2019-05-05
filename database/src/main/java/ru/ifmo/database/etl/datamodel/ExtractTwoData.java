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
public class ExtractTwoData<P, O> {
    private List<P> postgresEntityList;
    private List<O> oracleEntityList;
}
