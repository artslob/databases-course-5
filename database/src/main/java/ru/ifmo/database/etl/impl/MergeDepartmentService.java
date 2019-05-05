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

    private final PostgresDepartmentRepository postgresDepartmentRepository;
    private final OracleDepartmentRepository oracleDepartmentRepository;
    private final UnionDepartmentRepository unionDepartmentRepository;

    public MergeDepartmentService(PostgresDepartmentRepository postgresDepartmentRepository, OracleDepartmentRepository oracleDepartmentRepository, UnionDepartmentRepository unionDepartmentRepository) {
        this.postgresDepartmentRepository = postgresDepartmentRepository;
        this.oracleDepartmentRepository = oracleDepartmentRepository;
        this.unionDepartmentRepository = unionDepartmentRepository;
    }

    public ExtractTwoData<PostgresDepartment, OracleDepartment> extract() {
        List<PostgresDepartment> postgresPersonList = (List<PostgresDepartment>) postgresDepartmentRepository.findAll();
        List<OracleDepartment> oracleDepartmentList = (List<OracleDepartment>) oracleDepartmentRepository.findAll();

        postgresPersonList.forEach(p -> oracleDepartmentList.add(oracleDepartmentRepository.findById(p.getDepartmentId()).orElse(new OracleDepartment())));

        return new ExtractTwoData<>(postgresPersonList, oracleDepartmentList);
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

    public List<UnionDepartment> load(List<UnionDepartment> unionDepartments) {
//        List<UnionDepartment> unionDepartmentFromDB = (List<UnionDepartment>) unionDepartmentRepository.findAll();
//        UnionDepartmentFromDB.forEach(p -> {
//            if (!unionDepartmentList.contains(p)) {
//                unionDepartmentRepository.deleteById(p.getDepartmentId());
//            }
//        });

        return (List<UnionDepartment>) unionDepartmentRepository.saveAll(unionDepartments);
    }
}
