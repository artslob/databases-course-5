package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mysql.MySQLReaderInfo;
import ru.ifmo.database.entity.union.UnionReaderInfo;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mysql.MySQLReaderInfoRepository;
import ru.ifmo.database.repository.union.UnionReaderInfoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeReaderInfoService extends AbstractMergeService<ExtractOneData<MySQLReaderInfo>, UnionReaderInfo> {

    private final MySQLReaderInfoRepository mySQLRepository;
    private final UnionReaderInfoRepository unionRepository;

    public MergeReaderInfoService(MySQLReaderInfoRepository mySQLRepository, UnionReaderInfoRepository unionRepository) {
        this.mySQLRepository = mySQLRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MySQLReaderInfo> extract() {
        return new ExtractOneData<>((List<MySQLReaderInfo>) mySQLRepository.findAll());
    }

    public List<UnionReaderInfo> transform(ExtractOneData<MySQLReaderInfo> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionReaderInfo unionReaderInfo = new UnionReaderInfo();
            unionReaderInfo.setInfoId(p.getInfoId());
            unionReaderInfo.setReaderId(p.getReaderId());
            unionReaderInfo.setBookId(p.getBookId());
            unionReaderInfo.setObtainDate(p.getObtainDate());
            unionReaderInfo.setReturned(p.getReturned());

            return unionReaderInfo;
        }).collect(Collectors.toList());
    }

    public List<UnionReaderInfo> load(List<UnionReaderInfo> unionList) {
        return (List<UnionReaderInfo>) unionRepository.saveAll(unionList);
    }
}

