package ru.ifmo.database.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.mysql.MySQLPublication;

public interface MySQLPublicationRepository extends CrudRepository<MySQLPublication, Integer> {
}
