package ru.ifmo.database.repository.postgres;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.postgres.PostgresGrade;

public interface PostgresGradeRepository extends CrudRepository<PostgresGrade, Integer> {
}
