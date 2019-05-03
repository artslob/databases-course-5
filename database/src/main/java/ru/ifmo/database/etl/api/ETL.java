package ru.ifmo.database.etl.api;

import java.util.List;

public interface ETL<E, T> {

    E extract();

    List<T> transform(E extractData);

    List<T> load(List<T> transformData);
}
