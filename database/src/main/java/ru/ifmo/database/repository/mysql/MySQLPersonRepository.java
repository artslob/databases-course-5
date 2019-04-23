package ru.ifmo.database.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.mysql.MySQLPerson;

public interface MySQLPersonRepository extends CrudRepository<MySQLPerson, Integer> {

}
