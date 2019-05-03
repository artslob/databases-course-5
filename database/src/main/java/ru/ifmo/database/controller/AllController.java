package ru.ifmo.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.database.entity.union.UnionPerson;
import ru.ifmo.database.etl.impl.MergePersonService;

import java.util.List;

@RestController
@RequestMapping("/all")
public class AllController {

    @Autowired
    MergePersonService mergePersonService;

    @PostMapping("/merge/person")
    public List<UnionPerson> merge() {
        return mergePersonService.merge();
    }
}
