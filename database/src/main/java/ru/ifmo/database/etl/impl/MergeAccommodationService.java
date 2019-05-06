package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mongo.MongoAccommodation;
import ru.ifmo.database.entity.union.UnionAccommodation;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mongo.MongoAccommodationRepository;
import ru.ifmo.database.repository.union.UnionAccommodationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeAccommodationService extends AbstractMergeService<ExtractOneData<MongoAccommodation>, UnionAccommodation> {

    private final MongoAccommodationRepository mongoRepository;
    private final UnionAccommodationRepository unionRepository;

    public MergeAccommodationService(MongoAccommodationRepository mongoRepository, UnionAccommodationRepository unionRepository) {
        this.mongoRepository = mongoRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MongoAccommodation> extract() {
        return new ExtractOneData<>(mongoRepository.findAll());
    }

    public List<UnionAccommodation> transform(ExtractOneData<MongoAccommodation> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionAccommodation unionAccommodation = new UnionAccommodation();
            unionAccommodation.setAccommodationId(p.getAccommodationId());
            unionAccommodation.setPersonId(p.getPersonId());
            unionAccommodation.setRoomId(p.getRoomId());
            unionAccommodation.setAccFrom(p.getFrom());
            unionAccommodation.setAccTo(p.getTo());
            unionAccommodation.setExemption(p.getExemption() ? 1 : 0);

            return unionAccommodation;
        }).collect(Collectors.toList());
    }

    public List<UnionAccommodation> load(List<UnionAccommodation> unionList) {
        return (List<UnionAccommodation>) unionRepository.saveAll(unionList);
    }
}
