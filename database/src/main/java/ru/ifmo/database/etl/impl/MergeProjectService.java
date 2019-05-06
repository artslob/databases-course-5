package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mysql.MySQLProject;
import ru.ifmo.database.entity.union.UnionProject;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mysql.MySQLProjectRepository;
import ru.ifmo.database.repository.union.UnionProjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeProjectService extends AbstractMergeService<ExtractOneData<MySQLProject>, UnionProject> {

    private final MySQLProjectRepository mySQLRepository;
    private final UnionProjectRepository unionRepository;

    public MergeProjectService(MySQLProjectRepository mySQLRepository, UnionProjectRepository unionRepository) {
        this.mySQLRepository = mySQLRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MySQLProject> extract() {
        return new ExtractOneData<>((List<MySQLProject>) mySQLRepository.findAll());
    }

    public List<UnionProject> transform(ExtractOneData<MySQLProject> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionProject unionProject = new UnionProject();
            unionProject.setProjectId(p.getProjectId());
            unionProject.setTitle(p.getTitle());
            unionProject.setProjectStart(p.getProjectStart());
            unionProject.setProjectEnd(p.getProjectEnd());

            return unionProject;
        }).collect(Collectors.toList());
    }

    public List<UnionProject> load(List<UnionProject> unionList) {
        return (List<UnionProject>) unionRepository.saveAll(unionList);
    }
}
