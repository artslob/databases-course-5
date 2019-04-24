package ru.ifmo.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.ifmo.database.entity.mysql.MySQLPerson;
import ru.ifmo.database.entity.oracle.OraclePerson;
import ru.ifmo.database.entity.postgres.PostgresPerson;
import ru.ifmo.database.repository.mysql.MySQLPersonRepository;
import ru.ifmo.database.repository.oracle.OraclePersonRepository;
import ru.ifmo.database.repository.postgres.PostgresPersonRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Autowired
	private MySQLPersonRepository mySQLPersonRepository;

	@Autowired
	private PostgresPersonRepository postgresPersonRepository;

	@Autowired
	private OraclePersonRepository oraclePersonRepository;

	@PostConstruct
	void init () {

	    mySQLPersonRepository.findAll().forEach(System.out::println);
        postgresPersonRepository.findAll().forEach(System.out::println);
        oraclePersonRepository.findAll().forEach(System.out::println);

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
