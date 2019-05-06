package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.postgres.PostgresUniversity;
import ru.ifmo.database.entity.union.UnionUniversity;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.postgres.PostgresUniversityRepository;
import ru.ifmo.database.repository.union.UnionUniversityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeUniversityService extends AbstractMergeService<ExtractOneData<PostgresUniversity>, UnionUniversity> {

    private final PostgresUniversityRepository postgresRepository;
    private final UnionUniversityRepository unionRepository;

    public MergeUniversityService(PostgresUniversityRepository postgresRepository, UnionUniversityRepository unionRepository) {
        this.postgresRepository = postgresRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<PostgresUniversity> extract() {
        return new ExtractOneData<>((List<PostgresUniversity>) postgresRepository.findAll());
    }

    public List<UnionUniversity> transform(ExtractOneData<PostgresUniversity> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionUniversity unionUniversity = new UnionUniversity();
            unionUniversity.setUniversityId(p.getUniversityId());
            unionUniversity.setName(p.getName());

            return unionUniversity;
        }).collect(Collectors.toList());
    }

    public List<UnionUniversity> load(List<UnionUniversity> unionList) {
        return (List<UnionUniversity>) unionRepository.saveAll(unionList);
    }
}
