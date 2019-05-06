package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mysql.MySQLPublication;
import ru.ifmo.database.entity.union.UnionPublication;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mysql.MySQLPublicationRepository;
import ru.ifmo.database.repository.union.UnionPublicationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergePublicationService extends AbstractMergeService<ExtractOneData<MySQLPublication>, UnionPublication> {

    private final MySQLPublicationRepository mySQLRepository;
    private final UnionPublicationRepository unionRepository;

    public MergePublicationService(MySQLPublicationRepository mySQLRepository, UnionPublicationRepository unionRepository) {
        this.mySQLRepository = mySQLRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MySQLPublication> extract() {
        return new ExtractOneData<>((List<MySQLPublication>) mySQLRepository.findAll());
    }

    public List<UnionPublication> transform(ExtractOneData<MySQLPublication> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionPublication unionPublication = new UnionPublication();
            unionPublication.setPublicationId(p.getPublicationId());
            unionPublication.setTitle(p.getTitle());
            unionPublication.setType(p.getType());
            unionPublication.setCitationIndex(p.getCitationIndex());

            return unionPublication;
        }).collect(Collectors.toList());
    }

    public List<UnionPublication> load(List<UnionPublication> unionList) {
        return (List<UnionPublication>) unionRepository.saveAll(unionList);
    }
}
