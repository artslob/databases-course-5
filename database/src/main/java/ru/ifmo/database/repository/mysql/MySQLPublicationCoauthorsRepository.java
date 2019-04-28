package ru.ifmo.database.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.database.entity.mysql.MySQLPublicationCoauthors;
import ru.ifmo.database.entity.mysql.MySQLPublicationCoauthorsPK;

public interface MySQLPublicationCoauthorsRepository extends CrudRepository<MySQLPublicationCoauthors, MySQLPublicationCoauthorsPK> {
}
