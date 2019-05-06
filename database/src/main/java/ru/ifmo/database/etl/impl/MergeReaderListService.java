package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mysql.MySQLReaderList;
import ru.ifmo.database.entity.union.UnionReaderList;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mysql.MySQLReaderListRepository;
import ru.ifmo.database.repository.union.UnionReaderListRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeReaderListService extends AbstractMergeService<ExtractOneData<MySQLReaderList>, UnionReaderList> {

    private final MySQLReaderListRepository oracleRepository;
    private final UnionReaderListRepository unionRepository;

    public MergeReaderListService(MySQLReaderListRepository oracleRepository, UnionReaderListRepository unionRepository) {
        this.oracleRepository = oracleRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MySQLReaderList> extract() {
        return new ExtractOneData<>((List<MySQLReaderList>) oracleRepository.findAll());
    }

    public List<UnionReaderList> transform(ExtractOneData<MySQLReaderList> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionReaderList unionReaderList = new UnionReaderList();
            unionReaderList.setListId(p.getListId());
            unionReaderList.setRegistrationDate(p.getRegistrationDate());
            unionReaderList.setPersonId(p.getPersonId());

            return unionReaderList;
        }).collect(Collectors.toList());
    }

    public List<UnionReaderList> load(List<UnionReaderList> unionList) {
        return (List<UnionReaderList>) unionRepository.saveAll(unionList);
    }
}
