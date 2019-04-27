package ru.ifmo.database.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ifmo.database.entity.mongo.MongoRoom;

public interface MongoRoomRepository extends MongoRepository<MongoRoom, String> {
}
