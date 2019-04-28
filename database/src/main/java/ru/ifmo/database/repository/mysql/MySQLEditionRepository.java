package ru.ifmo.database.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.mysql.MySQLEdition;

public interface MySQLEditionRepository extends CrudRepository<MySQLEdition, Integer> {
}
