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

    @Autowired
    private MongoRoomRepository mongoRoomRepository;
    @Autowired
    private MongoPersonRepository mongoPersonRepository;
    @Autowired
    private MongoVisitRepository mongoVisitRepository;
    @Autowired
    private MongoHostelRepository mongoHostelRepository;
    @Autowired
    private MongoAccommodationRepository mongoAccommodationRepository;

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
