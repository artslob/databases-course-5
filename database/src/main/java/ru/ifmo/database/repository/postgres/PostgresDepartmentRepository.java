package ru.ifmo.database.repository.postgres;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.postgres.PostgresDepartment;

public interface PostgresDepartmentRepository extends CrudRepository<PostgresDepartment, Integer> {
}
