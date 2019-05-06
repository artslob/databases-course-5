package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.oracle.OracleDiscipline;
import ru.ifmo.database.entity.postgres.PostgresDiscipline;
import ru.ifmo.database.entity.union.UnionDiscipline;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractTwoData;
import ru.ifmo.database.repository.oracle.OracleDisciplineRepository;
import ru.ifmo.database.repository.postgres.PostgresDisciplineRepository;
import ru.ifmo.database.repository.union.UnionDisciplineRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MergeDisciplineService extends AbstractMergeService<ExtractTwoData<PostgresDiscipline, OracleDiscipline>, UnionDiscipline> {

    private final PostgresDisciplineRepository postgresRepository;
    private final OracleDisciplineRepository oracleRepository;
    private final UnionDisciplineRepository unionRepository;

    public MergeDisciplineService(PostgresDisciplineRepository postgresRepository, OracleDisciplineRepository oracleRepository, UnionDisciplineRepository unionRepository) {
        this.postgresRepository = postgresRepository;
        this.oracleRepository = oracleRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractTwoData<PostgresDiscipline, OracleDiscipline> extract() {
        List<PostgresDiscipline> postgresList = (List<PostgresDiscipline>) postgresRepository.findAll();
        List<OracleDiscipline> oracleList = new ArrayList<>(postgresList.size());

        postgresList.forEach(p -> oracleList.add(oracleRepository.findById(p.getDisciplineId()).orElse(new OracleDiscipline())));

        return new ExtractTwoData<>(postgresList, oracleList);
    }

    public List<UnionDiscipline> transform(ExtractTwoData<PostgresDiscipline, OracleDiscipline> extractData) {
        List<UnionDiscipline> unionList = new ArrayList<>();
        for (int i = 0; i < extractData.getPostgresEntityList().size(); i++) {
            UnionDiscipline unionDiscipline = new UnionDiscipline();
            unionDiscipline.setDisciplineId(extractData.getPostgresEntityList().get(i).getDisciplineId());
            unionDiscipline.setName(extractData.getPostgresEntityList().get(i).getName());
            unionDiscipline.setLectures(extractData.getPostgresEntityList().get(i).getLectures());
            unionDiscipline.setPracticalLessons(extractData.getPostgresEntityList().get(i).getPracticalLessons());
            unionDiscipline.setLabs(extractData.getPostgresEntityList().get(i).getLabs());
            unionDiscipline.setControlForm(extractData.getPostgresEntityList().get(i).getControlForm());
            unionDiscipline.setSemester(extractData.getPostgresEntityList().get(i).getSemester());
            unionDiscipline.setSpecialityId(extractData.getPostgresEntityList().get(i).getSpecialityId());

            unionList.add(unionDiscipline);
        }
        return unionList;
    }

    public List<UnionDiscipline> load(List<UnionDiscipline> unionList) {
        return (List<UnionDiscipline>) unionRepository.saveAll(unionList);
    }
}

