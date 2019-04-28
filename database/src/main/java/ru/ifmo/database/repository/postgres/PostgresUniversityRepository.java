package ru.ifmo.database.repository.postgres;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.postgres.PostgresUniversity;

public interface PostgresUniversityRepository extends CrudRepository<PostgresUniversity, Integer> {
}
