package ru.ifmo.database.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ifmo.database.entity.mongo.MongoAccommodation;

public interface MongoAccommodationRepository extends MongoRepository<MongoAccommodation, String> {
}
