package ru.ifmo.database.repository.oracle;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.oracle.OracleGrade;

public interface OracleGradeRepository extends CrudRepository<OracleGrade, Integer> {
}
