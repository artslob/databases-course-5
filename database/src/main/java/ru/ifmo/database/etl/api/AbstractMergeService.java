package ru.ifmo.database.etl.api;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ifmo.database.repository.mongo.MongoPersonRepository;
import ru.ifmo.database.repository.mysql.MySQLPersonRepository;
import ru.ifmo.database.repository.oracle.OraclePersonRepository;
import ru.ifmo.database.repository.postgres.PostgresPersonRepository;
import ru.ifmo.database.repository.union.UnionPersonRepository;

import java.util.List;

public abstract class AbstractMergeService<E, T> implements ETL<E, T> {

    @Autowired
    protected MySQLPersonRepository mySQLPersonRepository;
    @Autowired
    protected PostgresPersonRepository postgresPersonRepository;
    @Autowired
    protected OraclePersonRepository oraclePersonRepository;
    @Autowired
    protected MongoPersonRepository mongoPersonRepository;
    @Autowired
    protected UnionPersonRepository unionPersonRepository;

    public abstract E extract();

    public abstract List<T> transform(E extractData);

    public abstract List<T> load(List<T> transformData);

    public List<T> merge() {
        return load(transform(extract()));
    }
}
