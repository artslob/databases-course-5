package ru.ifmo.database.repository.postgres;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.postgres.PostgresDiscipline;

public interface PostgresDisciplineRepository extends CrudRepository<PostgresDiscipline, Integer> {
}
