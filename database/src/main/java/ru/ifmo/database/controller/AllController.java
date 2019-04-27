package ru.ifmo.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.database.repository.mongo.MongoPersonRepository;
import ru.ifmo.database.repository.mysql.MySQLPersonRepository;
import ru.ifmo.database.repository.oracle.OraclePersonRepository;
import ru.ifmo.database.repository.postgres.PostgresPersonRepository;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/all")
public class AllController {

    @Autowired
    private MySQLPersonRepository mySQLPersonRepository;

    @Autowired
    private PostgresPersonRepository postgresPersonRepository;

    @Autowired
    private OraclePersonRepository oraclePersonRepository;

    @Autowired
    private MongoPersonRepository mongoPersonRepository;

    @GetMapping("/person")
    public List<Object> findAll() {
        return Arrays.asList(
                mongoPersonRepository.findAll(),
                mySQLPersonRepository.findAll(),
                postgresPersonRepository.findAll(),
                oraclePersonRepository.findAll()
        );

//    @PostMapping("/merge")
//		MySQLPerson mySQLPerson = mySQLPersonRepository.findAll().iterator().next();
//
//		PostgresPerson postgresPerson = postgresPersonRepository.findAll().iterator().next();
//
//		OraclePerson oraclePerson = new OraclePerson();
//		oraclePerson.setId(postgresPerson.getId());
//		oraclePerson.setName(postgresPerson.getName());
//		oraclePerson.setMiddleName(postgresPerson.getMiddleName());
//		oraclePerson.setSurname(postgresPerson.getSurname());
//		oraclePerson.setPersonType(postgresPerson.getPersonType());
//		oraclePerson.setSpecialityId(postgresPerson.getSpecialityId());
//		oraclePerson.setPosition(mySQLPerson.getPosition());
//
//		oraclePersonRepository.save(oraclePerson);
    }
}
