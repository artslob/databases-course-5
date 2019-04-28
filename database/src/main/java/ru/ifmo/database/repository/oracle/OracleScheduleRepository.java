package ru.ifmo.database.repository.oracle;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.oracle.OracleSchedule;

public interface OracleScheduleRepository extends CrudRepository<OracleSchedule, Integer> {
}
