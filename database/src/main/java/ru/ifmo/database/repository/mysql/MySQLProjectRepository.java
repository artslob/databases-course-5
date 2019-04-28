package ru.ifmo.database.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.mysql.MySQLProject;

public interface MySQLProjectRepository extends CrudRepository<MySQLProject, Integer> {
}
