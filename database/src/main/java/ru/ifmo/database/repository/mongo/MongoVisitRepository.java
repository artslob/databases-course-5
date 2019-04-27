package ru.ifmo.database.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ifmo.database.entity.mongo.MongoVisit;

public interface MongoVisitRepository extends MongoRepository<MongoVisit, String> {
}
