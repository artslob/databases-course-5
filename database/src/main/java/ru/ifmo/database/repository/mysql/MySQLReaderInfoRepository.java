package ru.ifmo.database.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.mysql.MySQLReaderInfo;

public interface MySQLReaderInfoRepository extends CrudRepository<MySQLReaderInfo, Integer> {
}
