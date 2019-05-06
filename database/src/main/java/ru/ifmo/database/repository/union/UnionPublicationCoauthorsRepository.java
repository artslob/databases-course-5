package ru.ifmo.database.repository.union;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.union.UnionPublicationCoauthors;
import ru.ifmo.database.entity.union.UnionPublicationCoauthorsPK;

public interface UnionPublicationCoauthorsRepository extends CrudRepository<UnionPublicationCoauthors, UnionPublicationCoauthorsPK> {
}
