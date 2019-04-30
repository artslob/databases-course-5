package ru.ifmo.database.repository.postgres;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.postgres.PostgresEducation;

public interface PostgresEducationRepository extends CrudRepository<PostgresEducation, Integer> {
}
