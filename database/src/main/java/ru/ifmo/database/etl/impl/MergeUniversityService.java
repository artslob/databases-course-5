package ru.ifmo.database.etl.impl;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PostgresUniversityRepository postgresUniversityRepository;
    @Autowired
    private UnionUniversityRepository unionUniversityRepository;

    public ExtractOneData<PostgresUniversity> extract() {
        List<PostgresUniversity> postgresPersonList = (List<PostgresUniversity>) postgresUniversityRepository.findAll();

        return new ExtractOneData<>(postgresPersonList);
    }

    public List<UnionUniversity> transform(ExtractOneData<PostgresUniversity> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionUniversity unionUniversity = new UnionUniversity();
            unionUniversity.setUniversityId(p.getUniversityId());
            unionUniversity.setName(p.getName());

            return unionUniversity;
        }).collect(Collectors.toList());
    }

    public List<UnionUniversity> load(List<UnionUniversity> unionUniversityList) {
//        List<UnionUniversity> unionUniversityFromDB = (List<UnionUniversity>) unionUniversityRepository.findAll();
//        UnionUniversityFromDB.forEach(p -> {
//            if (!unionUniversityList.contains(p)) {
//                unionUniversityRepository.deleteById(p.getUniversityId());
//            }
//        });

        return (List<UnionUniversity>) unionUniversityRepository.saveAll(unionUniversityList);
    }
}
