package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.oracle.OracleEducation;
import ru.ifmo.database.entity.postgres.PostgresEducation;
import ru.ifmo.database.entity.union.UnionEducation;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractTwoData;
import ru.ifmo.database.repository.oracle.OracleEducationRepository;
import ru.ifmo.database.repository.postgres.PostgresEducationRepository;
import ru.ifmo.database.repository.union.UnionEducationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MergeEducationService extends AbstractMergeService<ExtractTwoData<PostgresEducation, OracleEducation>, UnionEducation> {

    private final PostgresEducationRepository postgresRepository;
    private final OracleEducationRepository oracleRepository;
    private final UnionEducationRepository unionRepository;

    public MergeEducationService(PostgresEducationRepository postgresRepository, OracleEducationRepository oracleRepository, UnionEducationRepository unionRepository) {
        this.postgresRepository = postgresRepository;
        this.oracleRepository = oracleRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractTwoData<PostgresEducation, OracleEducation> extract() {
        List<PostgresEducation> postgresList = (List<PostgresEducation>) postgresRepository.findAll();
        List<OracleEducation> oracleList = new ArrayList<>(postgresList.size());

        postgresList.forEach(p -> oracleList.add(oracleRepository.findById(p.getEducationId()).orElse(new OracleEducation())));

        return new ExtractTwoData<>(postgresList, oracleList);
    }

    public List<UnionEducation> transform(ExtractTwoData<PostgresEducation, OracleEducation> extractData) {
        List<UnionEducation> unionEducationList = new ArrayList<>();
        for (int i = 0; i < extractData.getPostgresEntityList().size(); i++) {
            UnionEducation unionEducation = new UnionEducation();
            unionEducation.setEducationId(extractData.getPostgresEntityList().get(i).getEducationId());
            unionEducation.setEducationType(extractData.getPostgresEntityList().get(i).getEducationType());
            unionEducation.setEducationForm(extractData.getPostgresEntityList().get(i).getEducationForm());
            unionEducation.setQualification(extractData.getPostgresEntityList().get(i).getQualification());
            unionEducation.setStartDate(extractData.getPostgresEntityList().get(i).getStartDate());
            unionEducation.setEndDate(extractData.getPostgresEntityList().get(i).getEndDate());
            unionEducation.setCourse(extractData.getPostgresEntityList().get(i).getCourse());
            unionEducation.setSpecialityId(extractData.getPostgresEntityList().get(i).getSpecialityId());
            unionEducation.setPersonId(extractData.getPostgresEntityList().get(i).getPersonId());

            unionEducationList.add(unionEducation);
        }
        return unionEducationList;
    }

    public List<UnionEducation> load(List<UnionEducation> unionList) {
        return (List<UnionEducation>) unionRepository.saveAll(unionList);
    }
}
