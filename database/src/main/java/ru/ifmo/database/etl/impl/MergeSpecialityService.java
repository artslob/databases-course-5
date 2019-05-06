package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.oracle.OracleSpeciality;
import ru.ifmo.database.entity.postgres.PostgresSpeciality;
import ru.ifmo.database.entity.union.UnionSpeciality;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractTwoData;
import ru.ifmo.database.repository.oracle.OracleSpecialityRepository;
import ru.ifmo.database.repository.postgres.PostgresSpecialityRepository;
import ru.ifmo.database.repository.union.UnionSpecialityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MergeSpecialityService extends AbstractMergeService<ExtractTwoData<PostgresSpeciality, OracleSpeciality>, UnionSpeciality> {

    private final PostgresSpecialityRepository postgresRepository;
    private final OracleSpecialityRepository oracleRepository;
    private final UnionSpecialityRepository unionRepository;

    public MergeSpecialityService(PostgresSpecialityRepository postgresRepository, OracleSpecialityRepository oracleRepository, UnionSpecialityRepository unionRepository) {
        this.postgresRepository = postgresRepository;
        this.oracleRepository = oracleRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractTwoData<PostgresSpeciality, OracleSpeciality> extract() {
        List<PostgresSpeciality> postgresList = (List<PostgresSpeciality>) postgresRepository.findAll();
        List<OracleSpeciality> oracleList = new ArrayList<>(postgresList.size());

        postgresList.forEach(p -> oracleList.add(oracleRepository.findById(p.getSpecialityId()).orElse(new OracleSpeciality())));

        return new ExtractTwoData<>(postgresList, oracleList);
    }

    public List<UnionSpeciality> transform(ExtractTwoData<PostgresSpeciality, OracleSpeciality> extractData) {
        List<UnionSpeciality> unionList = new ArrayList<>();
        for (int i = 0; i < extractData.getPostgresEntityList().size(); i++) {
            UnionSpeciality unionSpeciality = new UnionSpeciality();
            unionSpeciality.setSpecialityId(extractData.getPostgresEntityList().get(i).getSpecialityId());
            unionSpeciality.setName(extractData.getPostgresEntityList().get(i).getName());
            unionSpeciality.setStandard(extractData.getPostgresEntityList().get(i).getStandard());
            unionSpeciality.setDepartmentId(extractData.getPostgresEntityList().get(i).getDepartmentId());

            unionSpeciality.setDirection(extractData.getOracleEntityList().get(i).getDirection());

            unionList.add(unionSpeciality);
        }
        return unionList;
    }

    public List<UnionSpeciality> load(List<UnionSpeciality> unionList) {
        return (List<UnionSpeciality>) unionRepository.saveAll(unionList);
    }
}
