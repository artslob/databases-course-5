package ru.ifmo.database.repository.oracle;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.oracle.OraclePerson;

public interface OraclePersonRepository extends CrudRepository<OraclePerson, Integer> {

}
