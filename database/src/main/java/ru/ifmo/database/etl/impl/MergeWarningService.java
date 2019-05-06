package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mongo.MongoAccommodation;
import ru.ifmo.database.entity.union.UnionWarning;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mongo.MongoAccommodationRepository;
import ru.ifmo.database.repository.union.UnionWarningRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeWarningService  extends AbstractMergeService<ExtractOneData<MongoAccommodation>, UnionWarning> {

    private final MongoAccommodationRepository mongoRepository;
    private final UnionWarningRepository unionRepository;

    public MergeWarningService(MongoAccommodationRepository mongoRepository, UnionWarningRepository unionRepository) {
        this.mongoRepository = mongoRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MongoAccommodation> extract() {
        return new ExtractOneData<>(mongoRepository.findAll());
    }

    public List<UnionWarning> transform(ExtractOneData<MongoAccommodation> extractData) {
        return extractData.getEntityList().stream().map(p -> p.getWarnings().stream().map(d -> {

            UnionWarning unionWarning = new UnionWarning();
            unionWarning.setAccommodationId(p.getAccommodationId());
            unionWarning.setWarningId(d.getWarningId());
            unionWarning.setWarningDate(d.getDate());
            unionWarning.setWarnText(d.getText());

            return unionWarning;
        }).collect(Collectors.toList())).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List<UnionWarning> load(List<UnionWarning> unionList) {
        return (List<UnionWarning>) unionRepository.saveAll(unionList);
    }
}

