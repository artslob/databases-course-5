package ru.ifmo.database.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ifmo.database.entity.mongo.MongoPerson;

public interface MongoPersonRepository extends MongoRepository<MongoPerson, Integer> {
}
