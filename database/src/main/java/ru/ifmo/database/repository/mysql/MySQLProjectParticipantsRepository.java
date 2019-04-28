package ru.ifmo.database.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.mysql.MySQLProjectParticipants;
import ru.ifmo.database.entity.mysql.MySQLProjectParticipantsPK;

public interface MySQLProjectParticipantsRepository extends CrudRepository<MySQLProjectParticipants, MySQLProjectParticipantsPK> {
}
