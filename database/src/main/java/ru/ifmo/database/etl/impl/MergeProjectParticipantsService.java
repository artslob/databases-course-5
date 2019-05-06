package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mysql.MySQLProjectParticipants;
import ru.ifmo.database.entity.union.UnionProjectParticipants;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mysql.MySQLProjectParticipantsRepository;
import ru.ifmo.database.repository.union.UnionProjectParticipantsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeProjectParticipantsService extends AbstractMergeService<ExtractOneData<MySQLProjectParticipants>, UnionProjectParticipants> {

    private final MySQLProjectParticipantsRepository mySQLRepository;
    private final UnionProjectParticipantsRepository unionRepository;

    public MergeProjectParticipantsService(MySQLProjectParticipantsRepository mySQLRepository, UnionProjectParticipantsRepository unionRepository) {
        this.mySQLRepository = mySQLRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MySQLProjectParticipants> extract() {
        return new ExtractOneData<>((List<MySQLProjectParticipants>) mySQLRepository.findAll());
    }

    public List<UnionProjectParticipants> transform(ExtractOneData<MySQLProjectParticipants> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionProjectParticipants unionProjectParticipants = new UnionProjectParticipants();
            unionProjectParticipants.setProjectId(p.getProjectId());
            unionProjectParticipants.setPersonId(p.getPersonId());

            return unionProjectParticipants;
        }).collect(Collectors.toList());
    }

    public List<UnionProjectParticipants> load(List<UnionProjectParticipants> unionList) {
        return (List<UnionProjectParticipants>) unionRepository.saveAll(unionList);
    }
}
