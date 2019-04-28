package ru.ifmo.database.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.mysql.MySQLConferenceParticipants;
import ru.ifmo.database.entity.mysql.MySQLConferenceParticipantsPK;

public interface MySQLConferenceParticipantsRepository extends CrudRepository<MySQLConferenceParticipants, MySQLConferenceParticipantsPK> {
}
