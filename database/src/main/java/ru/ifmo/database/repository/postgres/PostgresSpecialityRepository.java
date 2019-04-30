package ru.ifmo.database.repository.postgres;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.postgres.PostgresSpeciality;

public interface PostgresSpecialityRepository extends CrudRepository<PostgresSpeciality, Integer> {
}
