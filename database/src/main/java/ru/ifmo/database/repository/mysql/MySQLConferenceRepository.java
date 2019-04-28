package ru.ifmo.database.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.mysql.MySQLConference;

public interface MySQLConferenceRepository extends CrudRepository<MySQLConference, Integer> {
}
