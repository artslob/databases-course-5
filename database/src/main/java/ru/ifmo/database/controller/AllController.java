package ru.ifmo.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.database.entity.union.UnionPerson;
import ru.ifmo.database.etl.MergePerson;
import ru.ifmo.database.repository.mongo.MongoPersonRepository;
import ru.ifmo.database.repository.mysql.MySQLPersonRepository;
import ru.ifmo.database.repository.oracle.OraclePersonRepository;
import ru.ifmo.database.repository.postgres.PostgresPersonRepository;
import ru.ifmo.database.repository.union.UnionPersonRepository;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/all")
public class AllController {

    @Autowired
    UnionPersonRepository unionPersonRepository;
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
    }

    @PostMapping("/merge")
    public List<UnionPerson> merge() {
        MergePerson mergePerson = new MergePerson();
        return mergePerson.merge(
                mySQLPersonRepository,
                postgresPersonRepository,
                oraclePersonRepository,
                mongoPersonRepository,
                unionPersonRepository
        );
    }
}
