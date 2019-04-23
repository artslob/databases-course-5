package ru.ifmo.database.repository.postgres;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.postgres.PostgresPerson;

public interface PostgresPersonRepository extends CrudRepository<PostgresPerson, Integer> {

}