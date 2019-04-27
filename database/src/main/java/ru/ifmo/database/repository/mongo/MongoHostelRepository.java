package ru.ifmo.database.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ifmo.database.entity.mongo.MongoHostel;

public interface MongoHostelRepository extends MongoRepository<MongoHostel, String> {
}
