package ru.ifmo.database.repository.union;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.union.UnionProjectParticipants;
import ru.ifmo.database.entity.union.UnionProjectParticipantsPK;

public interface UnionProjectParticipantsRepository extends CrudRepository<UnionProjectParticipants, UnionProjectParticipantsPK> {
}
