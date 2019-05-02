package ru.ifmo.database.repository.union;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.union.UnionPerson;

public interface UnionPersonRepository extends CrudRepository<UnionPerson, Integer> {
}
