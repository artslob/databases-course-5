package ru.ifmo.database.repository.oracle;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.oracle.OracleDiscipline;
import ru.ifmo.database.entity.oracle.OracleWorkDisciplinePK;

public interface OracleDisciplineRepository extends CrudRepository<OracleDiscipline, OracleWorkDisciplinePK> {
}
