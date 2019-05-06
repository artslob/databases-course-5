package ru.ifmo.database.etl.impl;

import org.springframework.stereotype.Service;
import ru.ifmo.database.entity.mysql.MySQLBook;
import ru.ifmo.database.entity.union.UnionBook;
import ru.ifmo.database.etl.api.AbstractMergeService;
import ru.ifmo.database.etl.datamodel.ExtractOneData;
import ru.ifmo.database.repository.mysql.MySQLBookRepository;
import ru.ifmo.database.repository.union.UnionBookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeBookService extends AbstractMergeService<ExtractOneData<MySQLBook>, UnionBook> {

    private final MySQLBookRepository oracleRepository;
    private final UnionBookRepository unionRepository;

    public MergeBookService(MySQLBookRepository oracleRepository, UnionBookRepository unionRepository) {
        this.oracleRepository = oracleRepository;
        this.unionRepository = unionRepository;
    }

    public ExtractOneData<MySQLBook> extract() {
        return new ExtractOneData<>((List<MySQLBook>) oracleRepository.findAll());
    }

    public List<UnionBook> transform(ExtractOneData<MySQLBook> extractData) {
        return extractData.getEntityList().stream().map(p -> {
            UnionBook unionBook = new UnionBook();
            unionBook.setBookId(p.getBookId());
            unionBook.setTitle(p.getTitle());
            unionBook.setAuthor(p.getAuthor());
            unionBook.setPublicationDate(p.getPublicationDate());

            return unionBook;
        }).collect(Collectors.toList());
    }

    public List<UnionBook> load(List<UnionBook> unionList) {
        return (List<UnionBook>) unionRepository.saveAll(unionList);
    }
}
