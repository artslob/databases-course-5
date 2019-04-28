package ru.ifmo.database.repository.oracle;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.oracle.OraclePersonEducation;
import ru.ifmo.database.entity.oracle.OraclePersonEducationPK;

public interface OraclePersonEducationRepository extends CrudRepository<OraclePersonEducation, OraclePersonEducationPK> {
}
