package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mongo.MongoVisit;
import ru.ifmo.database.entity.union.UnionVisit;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mongo.MongoVisitRepository;
import ru.ifmo.database.repository.union.UnionVisitRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeVisitService extends AbstractMergeService<ExtractOneData<MongoVisit>, UnionVisit> {

    private final MongoVisitRepository mongoRepository;
    private final UnionVisitRepository unionRepository;

    public MergeVisitService(MongoVisitRepository mongoRepository, UnionVisitRepository unionRepository) {
        this.mongoRepository = mongoRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MongoVisit> extract() {
        return new ExtractOneData<>(mongoRepository.findAll());
    }

    public List<UnionVisit> transform(ExtractOneData<MongoVisit> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionVisit unionVisit = new UnionVisit();
            unionVisit.setVisitId(p.getVisitId());
            unionVisit.setPersonId(p.getPersonId());
            unionVisit.setHostelId(p.getHostelId());
            unionVisit.setInside(p.getInside());
            unionVisit.setOutside(p.getOutside());

            return unionVisit;
        }).collect(Collectors.toList());
    }

    public List<UnionVisit> load(List<UnionVisit> unionList) {
        return (List<UnionVisit>) unionRepository.saveAll(unionList);
    }
}
