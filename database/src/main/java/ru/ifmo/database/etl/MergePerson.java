package ru.ifmo.database.etl;

import ru.ifmo.database.entity.mongo.MongoPerson;
import ru.ifmo.database.entity.mysql.MySQLPerson;
import ru.ifmo.database.entity.oracle.OraclePerson;
import ru.ifmo.database.entity.postgres.PostgresPerson;
import ru.ifmo.database.entity.union.UnionPerson;
import ru.ifmo.database.repository.mongo.MongoPersonRepository;
import ru.ifmo.database.repository.mysql.MySQLPersonRepository;
import ru.ifmo.database.repository.oracle.OraclePersonRepository;
import ru.ifmo.database.repository.postgres.PostgresPersonRepository;
import ru.ifmo.database.repository.union.UnionPersonRepository;

import java.util.ArrayList;
import java.util.List;

public class MergePerson {

    public List<UnionPerson> merge(MySQLPersonRepository mySQLPersonRepository,
                                   PostgresPersonRepository postgresPersonRepository,
                                   OraclePersonRepository oraclePersonRepository,
                                   MongoPersonRepository mongoPersonRepository,
                                   UnionPersonRepository unionPersonRepository) {
        List<MongoPerson> mongoPersonList = mongoPersonRepository.findAll();
        List<MySQLPerson> mySQLPersonList = (List<MySQLPerson>) mySQLPersonRepository.findAll();
        List<PostgresPerson> postgresPersonList = (List<PostgresPerson>) postgresPersonRepository.findAll();
        List<OraclePerson> oraclePersonList = (List<OraclePerson>) oraclePersonRepository.findAll();

        unionPersonRepository.deleteAll();

        List<UnionPerson> unionPersonList = new ArrayList<>();
        for (int i = 0; i < postgresPersonList.size(); i++) {
            UnionPerson unionPerson = new UnionPerson();
            unionPerson.setPersonId(postgresPersonList.get(i).getPersonId());
            unionPerson.setName(postgresPersonList.get(i).getName());
            unionPerson.setSurname(postgresPersonList.get(i).getSurname());
            unionPerson.setMiddleName(postgresPersonList.get(i).getMiddleName());
            unionPerson.setPersonType(postgresPersonList.get(i).getPersonType());

            unionPerson.setPosition(mySQLPersonList.get(i).getPosition());

            unionPerson.setBirthday(oraclePersonList.get(i).getBirthday());
            unionPerson.setBirthplace(oraclePersonList.get(i).getBirthplace());

//            unionPerson.setStudyType(mongoPersonList.get(i).getStudyType());

            unionPersonList.add(unionPerson);
        }

        unionPersonRepository.saveAll(unionPersonList);

        return (List<UnionPerson>) unionPersonRepository.findAll();
    }
}
