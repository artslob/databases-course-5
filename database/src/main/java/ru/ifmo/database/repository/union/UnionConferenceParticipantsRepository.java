package ru.ifmo.database.repository.union;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.union.UnionConferenceParticipants;
import ru.ifmo.database.entity.union.UnionConferenceParticipantsPK;

public interface UnionConferenceParticipantsRepository extends CrudRepository<UnionConferenceParticipants, UnionConferenceParticipantsPK> {
}
