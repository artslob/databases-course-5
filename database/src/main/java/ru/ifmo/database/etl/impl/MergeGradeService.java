package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.oracle.OracleGrade;
import ru.ifmo.database.entity.postgres.PostgresGrade;
import ru.ifmo.database.entity.union.UnionGrade;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractTwoData;
import ru.ifmo.database.repository.oracle.OracleGradeRepository;
import ru.ifmo.database.repository.postgres.PostgresGradeRepository;
import ru.ifmo.database.repository.union.UnionGradeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MergeGradeService extends AbstractMergeService<ExtractTwoData<PostgresGrade, OracleGrade>, UnionGrade> {

    private final PostgresGradeRepository postgresRepository;
    private final OracleGradeRepository oracleRepository;
    private final UnionGradeRepository unionRepository;

    public MergeGradeService(PostgresGradeRepository postgresRepository, OracleGradeRepository oracleRepository, UnionGradeRepository unionRepository) {
        this.postgresRepository = postgresRepository;
        this.oracleRepository = oracleRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractTwoData<PostgresGrade, OracleGrade> extract() {
        List<PostgresGrade> postgresList = (List<PostgresGrade>) postgresRepository.findAll();
        List<OracleGrade> oracleList = new ArrayList<>(postgresList.size());

        postgresList.forEach(p -> oracleList.add(oracleRepository.findById(p.getGradeId()).orElse(new OracleGrade())));

        return new ExtractTwoData<>(postgresList, oracleList);
    }

    public List<UnionGrade> transform(ExtractTwoData<PostgresGrade, OracleGrade> extractData) {
        List<UnionGrade> unionGradeList = new ArrayList<>();
        for (int i = 0; i < extractData.getPostgresEntityList().size(); i++) {
            UnionGrade unionGrade = new UnionGrade();
            unionGrade.setGradeId(extractData.getPostgresEntityList().get(i).getGradeId());
            unionGrade.setGrade(extractData.getPostgresEntityList().get(i).getGrade());
            unionGrade.setGradeDate(extractData.getPostgresEntityList().get(i).getGradeDate());
            unionGrade.setPersonId(extractData.getPostgresEntityList().get(i).getPersonId());
            unionGrade.setDisciplineId(extractData.getPostgresEntityList().get(i).getDisciplineId());

            unionGradeList.add(unionGrade);
        }
        return unionGradeList;
    }

    public List<UnionGrade> load(List<UnionGrade> unionList) {
        return (List<UnionGrade>) unionRepository.saveAll(unionList);
    }
}
