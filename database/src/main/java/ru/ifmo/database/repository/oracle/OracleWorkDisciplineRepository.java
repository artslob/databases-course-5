package ru.ifmo.database.repository.oracle;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.oracle.OracleWorkDiscipline;
import ru.ifmo.database.entity.oracle.OracleWorkDisciplinePK;

public interface OracleWorkDisciplineRepository extends CrudRepository<OracleWorkDiscipline, OracleWorkDisciplinePK> {
}
