package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mongo.MongoHostel;
import ru.ifmo.database.entity.union.UnionHostel;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mongo.MongoHostelRepository;
import ru.ifmo.database.repository.union.UnionHostelRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeHostelService extends AbstractMergeService<ExtractOneData<MongoHostel>, UnionHostel> {

    private final MongoHostelRepository mongoRepository;
    private final UnionHostelRepository unionRepository;

    public MergeHostelService(MongoHostelRepository mongoRepository, UnionHostelRepository unionRepository) {
        this.mongoRepository = mongoRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MongoHostel> extract() {
        return new ExtractOneData<>(mongoRepository.findAll());
    }

    public List<UnionHostel> transform(ExtractOneData<MongoHostel> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionHostel unionHostel = new UnionHostel();
            unionHostel.setHostelId(p.getHostelId());
            unionHostel.setAddress(p.getAddress());
            unionHostel.setRooms(p.getRooms());

            return unionHostel;
        }).collect(Collectors.toList());
    }

    public List<UnionHostel> load(List<UnionHostel> unionList) {
        return (List<UnionHostel>) unionRepository.saveAll(unionList);
    }
}
