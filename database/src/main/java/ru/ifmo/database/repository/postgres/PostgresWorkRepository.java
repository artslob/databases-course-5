package ru.ifmo.database.repository.postgres;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.postgres.PostgresWork;

public interface PostgresWorkRepository extends CrudRepository<PostgresWork, Integer> {
}
