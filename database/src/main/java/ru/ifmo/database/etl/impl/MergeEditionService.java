package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mysql.MySQLEdition;
import ru.ifmo.database.entity.union.UnionEdition;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mysql.MySQLEditionRepository;
import ru.ifmo.database.repository.union.UnionEditionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeEditionService extends AbstractMergeService<ExtractOneData<MySQLEdition>, UnionEdition> {

    private final MySQLEditionRepository mySQLRepository;
    private final UnionEditionRepository unionRepository;

    public MergeEditionService(MySQLEditionRepository mySQLRepository, UnionEditionRepository unionRepository) {
        this.mySQLRepository = mySQLRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MySQLEdition> extract() {
        return new ExtractOneData<>((List<MySQLEdition>) mySQLRepository.findAll());
    }

    public List<UnionEdition> transform(ExtractOneData<MySQLEdition> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionEdition unionEdition = new UnionEdition();
            unionEdition.setEditionId(p.getEditionId());
            unionEdition.setTitle(p.getTitle());
            unionEdition.setLanguage(p.getLanguage());
            unionEdition.setVolume(p.getVolume());
            unionEdition.setPlace(p.getPlace());
            unionEdition.setType(p.getType());
            unionEdition.setPublicationId(p.getPublicationId());

            return unionEdition;
        }).collect(Collectors.toList());
    }

    public List<UnionEdition> load(List<UnionEdition> unionList) {
        return (List<UnionEdition>) unionRepository.saveAll(unionList);
    }
}
