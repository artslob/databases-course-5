package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mysql.MySQLConference;
import ru.ifmo.database.entity.union.UnionConference;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mysql.MySQLConferenceRepository;
import ru.ifmo.database.repository.union.UnionConferenceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeConferenceService extends AbstractMergeService<ExtractOneData<MySQLConference>, UnionConference> {

    private final MySQLConferenceRepository mySQLRepository;
    private final UnionConferenceRepository unionRepository;

    public MergeConferenceService(MySQLConferenceRepository mySQLRepository, UnionConferenceRepository unionRepository) {
        this.mySQLRepository = mySQLRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MySQLConference> extract() {
        return new ExtractOneData<>((List<MySQLConference>) mySQLRepository.findAll());
    }

    public List<UnionConference> transform(ExtractOneData<MySQLConference> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionConference unionConference = new UnionConference();
            unionConference.setConferenceId(p.getConferenceId());
            unionConference.setTitle(p.getTitle());
            unionConference.setPlace(p.getPlace());
            unionConference.setConferenceDate(p.getConferenceDate());

            return unionConference;
        }).collect(Collectors.toList());
    }

    public List<UnionConference> load(List<UnionConference> unionList) {
        return (List<UnionConference>) unionRepository.saveAll(unionList);
    }
}
