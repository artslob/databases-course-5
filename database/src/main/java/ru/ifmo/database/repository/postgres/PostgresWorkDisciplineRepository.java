package ru.ifmo.database.repository.postgres;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.postgres.PostgresWorkDiscipline;
import ru.ifmo.database.entity.postgres.PostgresWorkDisciplinePK;

public interface PostgresWorkDisciplineRepository extends CrudRepository<PostgresWorkDiscipline, PostgresWorkDisciplinePK> {
}
