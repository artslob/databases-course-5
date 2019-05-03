package ru.ifmo.database.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ifmo.database.entity.mongo.MongoPerson;

import java.util.Optional;

public interface MongoPersonRepository extends MongoRepository<MongoPerson, String> {
    Optional<MongoPerson> findByPersonId(int id);
}
