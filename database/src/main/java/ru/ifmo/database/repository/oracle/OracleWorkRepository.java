package ru.ifmo.database.repository.oracle;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.oracle.OracleWork;

public interface OracleWorkRepository extends CrudRepository<OracleWork, Integer> {
}
