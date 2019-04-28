package ru.ifmo.database.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.mysql.MySQLBook;

public interface MySQLBookRepository extends CrudRepository<MySQLBook, Integer> {
}
