package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.oracle.OracleSchedule;
import ru.ifmo.database.entity.union.UnionSchedule;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.oracle.OracleScheduleRepository;
import ru.ifmo.database.repository.union.UnionScheduleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeScheduleService extends AbstractMergeService<ExtractOneData<OracleSchedule>, UnionSchedule> {

    private final OracleScheduleRepository oracleRepository;
    private final UnionScheduleRepository unionRepository;

    public MergeScheduleService(OracleScheduleRepository oracleRepository, UnionScheduleRepository unionRepository) {
        this.oracleRepository = oracleRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<OracleSchedule> extract() {
        return new ExtractOneData<>((List<OracleSchedule>) oracleRepository.findAll());
    }

    public List<UnionSchedule> transform(ExtractOneData<OracleSchedule> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionSchedule unionSchedule = new UnionSchedule();
            unionSchedule.setScheduleId(p.getScheduleId());
            unionSchedule.setClassroom(p.getClassroom());
            unionSchedule.setTimeDescription(p.getTimeDescription());
            unionSchedule.setDisciplineId(p.getDisciplineId());

            return unionSchedule;
        }).collect(Collectors.toList());
    }

    public List<UnionSchedule> load(List<UnionSchedule> unionList) {
        return (List<UnionSchedule>) unionRepository.saveAll(unionList);
    }
}
