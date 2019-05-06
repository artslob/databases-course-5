package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mysql.MySQLPublicationCoauthors;
import ru.ifmo.database.entity.union.UnionPublicationCoauthors;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mysql.MySQLPublicationCoauthorsRepository;
import ru.ifmo.database.repository.union.UnionPublicationCoauthorsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergePublicationCoauthorsService extends AbstractMergeService<ExtractOneData<MySQLPublicationCoauthors>, UnionPublicationCoauthors> {

    private final MySQLPublicationCoauthorsRepository mySQLRepository;
    private final UnionPublicationCoauthorsRepository unionRepository;

    public MergePublicationCoauthorsService(MySQLPublicationCoauthorsRepository mySQLRepository, UnionPublicationCoauthorsRepository unionRepository) {
        this.mySQLRepository = mySQLRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MySQLPublicationCoauthors> extract() {
        return new ExtractOneData<>((List<MySQLPublicationCoauthors>) mySQLRepository.findAll());
    }

    public List<UnionPublicationCoauthors> transform(ExtractOneData<MySQLPublicationCoauthors> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionPublicationCoauthors unionPublicationCoauthors = new UnionPublicationCoauthors();
            unionPublicationCoauthors.setPublicationId(p.getPublicationId());
            unionPublicationCoauthors.setPersonId(p.getPersonId());

            return unionPublicationCoauthors;
        }).collect(Collectors.toList());
    }

    public List<UnionPublicationCoauthors> load(List<UnionPublicationCoauthors> unionList) {
        return (List<UnionPublicationCoauthors>) unionRepository.saveAll(unionList);
    }
}
