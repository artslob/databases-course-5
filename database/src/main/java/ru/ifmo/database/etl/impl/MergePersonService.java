package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mongo.MongoPerson;
import ru.ifmo.database.entity.mysql.MySQLPerson;
import ru.ifmo.database.entity.oracle.OraclePerson;
import ru.ifmo.database.entity.postgres.PostgresPerson;
import ru.ifmo.database.entity.union.UnionPerson;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractData;

import java.util.ArrayList;
import java.util.List;

@Service
public class MergePersonService extends AbstractMergeService<ExtractData<PostgresPerson, MySQLPerson, OraclePerson, MongoPerson>, UnionPerson> {

    public ExtractData<PostgresPerson, MySQLPerson, OraclePerson, MongoPerson> extract() {
        List<PostgresPerson> postgresPersonList = (List<PostgresPerson>) postgresPersonRepository.findAll();
        List<MySQLPerson> mySQLPersonList = new ArrayList<>(postgresPersonList.size());
        List<OraclePerson> oraclePersonList = new ArrayList<>(postgresPersonList.size());
        List<MongoPerson> mongoPersonList = new ArrayList<>(postgresPersonList.size());

        postgresPersonList.forEach(p -> {
            mySQLPersonList.add(mySQLPersonRepository.findById(p.getPersonId()).orElse(new MySQLPerson()));
            oraclePersonList.add(oraclePersonRepository.findById(p.getPersonId()).orElse(new OraclePerson()));
            mongoPersonList.add(mongoPersonRepository.findByPersonId(p.getPersonId()).orElse(new MongoPerson()));
        });

        return new ExtractData<>(postgresPersonList, mySQLPersonList, oraclePersonList, mongoPersonList);
    }

    public List<UnionPerson> transform(ExtractData<PostgresPerson, MySQLPerson, OraclePerson, MongoPerson> extractData) {
        List<UnionPerson> unionPersonList = new ArrayList<>();
        for (int i = 0; i < extractData.getPostgresEntityList().size(); i++) {
            UnionPerson unionPerson = new UnionPerson();

            unionPerson.setPersonId(extractData.getPostgresEntityList().get(i).getPersonId());
            unionPerson.setName(extractData.getPostgresEntityList().get(i).getName());
            unionPerson.setSurname(extractData.getPostgresEntityList().get(i).getSurname());
            unionPerson.setMiddleName(extractData.getPostgresEntityList().get(i).getMiddleName());
            unionPerson.setPersonType(extractData.getPostgresEntityList().get(i).getPersonType());

            unionPerson.setPosition(extractData.getMySQLEntityList().get(i).getPosition());

            unionPerson.setBirthday(extractData.getOracleEntityList().get(i).getBirthday());
            unionPerson.setBirthplace(extractData.getOracleEntityList().get(i).getBirthplace());

            unionPersonList.add(unionPerson);
        }
        return unionPersonList;
    }

    public List<UnionPerson> load(List<UnionPerson> unionPersonList) {
        List<UnionPerson> unionPersonFromDB = (List<UnionPerson>) unionPersonRepository.findAll();

        unionPersonFromDB.forEach(p -> {
            if (!unionPersonList.contains(p)) {
                unionPersonRepository.deleteById(p.getPersonId());
            }
        });

        return (List<UnionPerson>) unionPersonRepository.saveAll(unionPersonList);
    }
}
