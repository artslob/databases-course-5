package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mongo.MongoRoom;
import ru.ifmo.database.entity.union.UnionDisinfection;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mongo.MongoRoomRepository;
import ru.ifmo.database.repository.union.UnionDisinfectionRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeDisinfectionService extends AbstractMergeService<ExtractOneData<MongoRoom>, UnionDisinfection> {

    private final MongoRoomRepository mongoRepository;
    private final UnionDisinfectionRepository unionRepository;

    public MergeDisinfectionService(MongoRoomRepository mongoRepository, UnionDisinfectionRepository unionRepository) {
        this.mongoRepository = mongoRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MongoRoom> extract() {
        return new ExtractOneData<>(mongoRepository.findAll());
    }

    public List<UnionDisinfection> transform(ExtractOneData<MongoRoom> extractData) {
        return extractData.getEntityList().stream().map(p -> p.getDisinfection().stream().map(d -> {

            UnionDisinfection unionDisinfection = new UnionDisinfection();
            unionDisinfection.setRoomId(p.getRoomId());
            unionDisinfection.setDisinfectionId(d.getDisinfectionId());
            unionDisinfection.setDisinfectionDate(d.getDate());

            return unionDisinfection;
        }).collect(Collectors.toList())).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List<UnionDisinfection> load(List<UnionDisinfection> unionList) {
        return (List<UnionDisinfection>) unionRepository.saveAll(unionList);
    }
}
