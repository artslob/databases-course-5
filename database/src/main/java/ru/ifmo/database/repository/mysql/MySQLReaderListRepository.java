package ru.ifmo.database.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.mysql.MySQLReaderList;

public interface MySQLReaderListRepository extends CrudRepository<MySQLReaderList, Integer> {
}
