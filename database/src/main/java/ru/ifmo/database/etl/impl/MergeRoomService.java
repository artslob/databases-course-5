package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mongo.MongoRoom;
import ru.ifmo.database.entity.union.UnionRoom;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mongo.MongoRoomRepository;
import ru.ifmo.database.repository.union.UnionRoomRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeRoomService extends AbstractMergeService<ExtractOneData<MongoRoom>, UnionRoom> {

    private final MongoRoomRepository mongoRepository;
    private final UnionRoomRepository unionRepository;

    public MergeRoomService(MongoRoomRepository mongoRepository, UnionRoomRepository unionRepository) {
        this.mongoRepository = mongoRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MongoRoom> extract() {
        return new ExtractOneData<>(mongoRepository.findAll());
    }

    public List<UnionRoom> transform(ExtractOneData<MongoRoom> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionRoom unionRoom = new UnionRoom();
            unionRoom.setRoomId(p.getRoomId());
            unionRoom.setHostelId(p.getHostelId());
            unionRoom.setRoomNumber(p.getRoomNumber());
            unionRoom.setCapacity(p.getCapacity());
            unionRoom.setPayment(p.getPayment());
            unionRoom.setInsects(p.getInsects() ? 1 : 0);

            return unionRoom;
        }).collect(Collectors.toList());
    }

    public List<UnionRoom> load(List<UnionRoom> unionList) {
        return (List<UnionRoom>) unionRepository.saveAll(unionList);
    }
}

