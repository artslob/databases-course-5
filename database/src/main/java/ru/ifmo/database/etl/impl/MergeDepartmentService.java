package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.oracle.OracleDepartment;
import ru.ifmo.database.entity.postgres.PostgresDepartment;
import ru.ifmo.database.entity.union.UnionDepartment;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractTwoData;
import ru.ifmo.database.repository.oracle.OracleDepartmentRepository;
import ru.ifmo.database.repository.postgres.PostgresDepartmentRepository;
import ru.ifmo.database.repository.union.UnionDepartmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MergeDepartmentService extends AbstractMergeService<ExtractTwoData<PostgresDepartment, OracleDepartment>, UnionDepartment> {

    private final PostgresDepartmentRepository postgresRepository;
    private final OracleDepartmentRepository oracleRepository;
    private final UnionDepartmentRepository unionRepository;

    public MergeDepartmentService(PostgresDepartmentRepository postgresRepository, OracleDepartmentRepository oracleRepository, UnionDepartmentRepository unionRepository) {
        this.postgresRepository = postgresRepository;
        this.oracleRepository = oracleRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractTwoData<PostgresDepartment, OracleDepartment> extract() {
        List<PostgresDepartment> postgresList = (List<PostgresDepartment>) postgresRepository.findAll();
        List<OracleDepartment> oracleList = new ArrayList<>(postgresList.size());

        postgresList.forEach(p -> oracleList.add(oracleRepository.findById(p.getDepartmentId()).orElse(new OracleDepartment())));

        return new ExtractTwoData<>(postgresList, oracleList);
    }

    public List<UnionDepartment> transform(ExtractTwoData<PostgresDepartment, OracleDepartment> extractData) {
        List<UnionDepartment> unionDepartmentList = new ArrayList<>();
        for (int i = 0; i < extractData.getPostgresEntityList().size(); i++) {
            UnionDepartment unionDepartment = new UnionDepartment();
            unionDepartment.setDepartmentId(extractData.getPostgresEntityList().get(i).getDepartmentId());
            unionDepartment.setFaculty(extractData.getPostgresEntityList().get(i).getFaculty());
            unionDepartment.setUniversityId(extractData.getPostgresEntityList().get(i).getUniversityId());

            unionDepartmentList.add(unionDepartment);
        }
        return unionDepartmentList;
    }

    public List<UnionDepartment> load(List<UnionDepartment> unionList) {
        return (List<UnionDepartment>) unionRepository.saveAll(unionList);
    }
}
