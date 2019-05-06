package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mysql.MySQLConferenceParticipants;
import ru.ifmo.database.entity.union.UnionConferenceParticipants;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mysql.MySQLConferenceParticipantsRepository;
import ru.ifmo.database.repository.union.UnionConferenceParticipantsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeConferenceParticipantsService extends AbstractMergeService<ExtractOneData<MySQLConferenceParticipants>, UnionConferenceParticipants> {

    private final MySQLConferenceParticipantsRepository mySQLRepository;
    private final UnionConferenceParticipantsRepository unionRepository;

    public MergeConferenceParticipantsService(MySQLConferenceParticipantsRepository mySQLRepository, UnionConferenceParticipantsRepository unionRepository) {
        this.mySQLRepository = mySQLRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MySQLConferenceParticipants> extract() {
        return new ExtractOneData<>((List<MySQLConferenceParticipants>) mySQLRepository.findAll());
    }

    public List<UnionConferenceParticipants> transform(ExtractOneData<MySQLConferenceParticipants> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionConferenceParticipants unionConferenceParticipants = new UnionConferenceParticipants();
            unionConferenceParticipants.setConferenceId(p.getConferenceId());
            unionConferenceParticipants.setPersonId(p.getPersonId());

            return unionConferenceParticipants;
        }).collect(Collectors.toList());
    }

    public List<UnionConferenceParticipants> load(List<UnionConferenceParticipants> unionList) {
        return (List<UnionConferenceParticipants>) unionRepository.saveAll(unionList);
    }
}
