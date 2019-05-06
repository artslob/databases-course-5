package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.oracle.OracleWork;
import ru.ifmo.database.entity.postgres.PostgresWork;
import ru.ifmo.database.entity.union.UnionUniversity;
import ru.ifmo.database.entity.union.UnionWork;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractTwoData;
import ru.ifmo.database.repository.oracle.OracleWorkRepository;
import ru.ifmo.database.repository.postgres.PostgresWorkRepository;
import ru.ifmo.database.repository.union.UnionWorkRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MergeWorkService extends AbstractMergeService<ExtractTwoData<PostgresWork, OracleWork>, UnionWork> {

    private final PostgresWorkRepository postgresRepository;
    private final OracleWorkRepository oracleRepository;
    private final UnionWorkRepository unionRepository;

    public MergeWorkService(PostgresWorkRepository postgresRepository, OracleWorkRepository oracleRepository, UnionWorkRepository unionRepository) {
        this.postgresRepository = postgresRepository;
        this.oracleRepository = oracleRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractTwoData<PostgresWork, OracleWork> extract() {
        List<PostgresWork> postgresList = (List<PostgresWork>) postgresRepository.findAll();
        List<OracleWork> oracleList = new ArrayList<>(postgresList.size());

        postgresList.forEach(p -> oracleList.add(oracleRepository.findById(p.getWorkId()).orElse(new OracleWork())));

        return new ExtractTwoData<>(postgresList, oracleList);
    }

    public List<UnionWork> transform(ExtractTwoData<PostgresWork, OracleWork> extractData) {
        List<UnionWork> unionWorkList = new ArrayList<>();
        for (int i = 0; i < extractData.getPostgresEntityList().size(); i++) {
            UnionWork unionWork = new UnionWork();
            unionWork.setWorkId(extractData.getPostgresEntityList().get(i).getWorkId());
            unionWork.setPosition(extractData.getPostgresEntityList().get(i).getPosition());
            unionWork.setWorkStart(extractData.getPostgresEntityList().get(i).getWorkStart());
            unionWork.setWorkEnd(extractData.getPostgresEntityList().get(i).getWorkEnd());
            unionWork.setPersonId(extractData.getPostgresEntityList().get(i).getPersonId());

            unionWorkList.add(unionWork);
        }
        return unionWorkList;
    }

    public List<UnionWork> load(List<UnionWork> unionList) {
        List<UnionWork> unionFromDB = (List<UnionWork>) unionRepository.findAll();
        unionFromDB.forEach(p -> {
            if (!unionList.contains(p)) {
                unionRepository.deleteById(p.getWorkId());
            }
        });
        return (List<UnionWork>) unionRepository.saveAll(unionList);
    }
}
