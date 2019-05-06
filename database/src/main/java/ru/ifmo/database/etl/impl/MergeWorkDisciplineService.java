package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.oracle.OracleWorkDiscipline;
import ru.ifmo.database.entity.oracle.OracleWorkDisciplinePK;
import ru.ifmo.database.entity.postgres.PostgresWorkDiscipline;
import ru.ifmo.database.entity.union.UnionWorkDiscipline;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractTwoData;
import ru.ifmo.database.repository.oracle.OracleWorkDisciplineRepository;
import ru.ifmo.database.repository.postgres.PostgresWorkDisciplineRepository;
import ru.ifmo.database.repository.union.UnionWorkDisciplineRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MergeWorkDisciplineService extends AbstractMergeService<ExtractTwoData<PostgresWorkDiscipline, OracleWorkDiscipline>, UnionWorkDiscipline> {

    private final PostgresWorkDisciplineRepository postgresRepository;
    private final OracleWorkDisciplineRepository oracleRepository;
    private final UnionWorkDisciplineRepository unionRepository;

    public MergeWorkDisciplineService(PostgresWorkDisciplineRepository postgresRepository, OracleWorkDisciplineRepository oracleRepository, UnionWorkDisciplineRepository unionRepository) {
        this.postgresRepository = postgresRepository;
        this.oracleRepository = oracleRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractTwoData<PostgresWorkDiscipline, OracleWorkDiscipline> extract() {
        List<PostgresWorkDiscipline> postgresList = (List<PostgresWorkDiscipline>) postgresRepository.findAll();
        List<OracleWorkDiscipline> oracleList = new ArrayList<>(postgresList.size());

        postgresList.forEach(p -> {
            OracleWorkDisciplinePK id = new OracleWorkDisciplinePK();
            id.setWorkId(p.getWorkId());
            id.setDisciplineId(p.getDisciplineId());
            oracleList.add(oracleRepository.findById(id).orElse(new OracleWorkDiscipline()));
        });

        return new ExtractTwoData<>(postgresList, oracleList);
    }

    public List<UnionWorkDiscipline> transform(ExtractTwoData<PostgresWorkDiscipline, OracleWorkDiscipline> extractData) {
        List<UnionWorkDiscipline> unionWorkDisciplineList = new ArrayList<>();
        for (int i = 0; i < extractData.getPostgresEntityList().size(); i++) {
            UnionWorkDiscipline unionWorkDiscipline = new UnionWorkDiscipline();
            unionWorkDiscipline.setWorkId(extractData.getPostgresEntityList().get(i).getWorkId());
            unionWorkDiscipline.setDisciplineId(extractData.getPostgresEntityList().get(i).getDisciplineId());

            unionWorkDisciplineList.add(unionWorkDiscipline);
        }
        return unionWorkDisciplineList;
    }

    public List<UnionWorkDiscipline> load(List<UnionWorkDiscipline> unionList) {
        return (List<UnionWorkDiscipline>) unionRepository.saveAll(unionList);
    }
}
