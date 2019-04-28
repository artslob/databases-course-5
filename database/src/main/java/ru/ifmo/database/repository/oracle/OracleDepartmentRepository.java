package ru.ifmo.database.repository.oracle;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.oracle.OracleDepartment;

public interface OracleDepartmentRepository extends CrudRepository<OracleDepartment, Integer> {
}
