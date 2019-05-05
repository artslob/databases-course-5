package ru.ifmo.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.database.entity.mongo.*;
import ru.ifmo.database.repository.mongo.*;

import java.util.List;

@RestController
@RequestMapping("/mongo")
public class MongoController {

    private final MongoRoomRepository mongoRoomRepository;
    private final MongoPersonRepository mongoPersonRepository;
    private final MongoVisitRepository mongoVisitRepository;
    private final MongoHostelRepository mongoHostelRepository;
    private final MongoAccommodationRepository mongoAccommodationRepository;

    public MongoController(MongoRoomRepository mongoRoomRepository, MongoPersonRepository mongoPersonRepository, MongoVisitRepository mongoVisitRepository, MongoHostelRepository mongoHostelRepository, MongoAccommodationRepository mongoAccommodationRepository) {
        this.mongoRoomRepository = mongoRoomRepository;
        this.mongoPersonRepository = mongoPersonRepository;
        this.mongoVisitRepository = mongoVisitRepository;
        this.mongoHostelRepository = mongoHostelRepository;
        this.mongoAccommodationRepository = mongoAccommodationRepository;
    }

    @GetMapping("/room")
    public List<MongoRoom> findAllRooms() {
        return mongoRoomRepository.findAll();
    }

    @GetMapping("/person")
    public List<MongoPerson> findAllPersons() {
        return mongoPersonRepository.findAll();
    }

    @GetMapping("/visit")
    public List<MongoVisit> findAllVisits() {
        return mongoVisitRepository.findAll();
    }

    @GetMapping("/hostel")
    public List<MongoHostel> findAllHostels() {
        return mongoHostelRepository.findAll();
    }

    @GetMapping("/accommodation")
    public List<MongoAccommodation> findAllAccommodations() {
        return mongoAccommodationRepository.findAll();
    }
}
