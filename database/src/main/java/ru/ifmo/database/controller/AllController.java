package ru.ifmo.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.database.entity.union.UnionPerson;
import ru.ifmo.database.entity.union.UnionUniversity;
import ru.ifmo.database.etl.impl.MergePersonService;
import ru.ifmo.database.etl.impl.MergeUniversityService;

import java.util.List;

@RestController
@RequestMapping("/all")
public class AllController {

    @Autowired
    MergePersonService mergePersonService;
    @Autowired
    MergeUniversityService mergeUniversityService;

    @PostMapping("/merge/all")
    public String mergeAll() {
        try {
            mergePerson();
            mergeUniversity();
            return "Success";
        } catch (Exception ex) {
            ex.getStackTrace();
            return "Failed";
        }
    }

    @PostMapping("/merge/person")
    public List<UnionPerson> mergePerson() {
        return mergePersonService.merge();
    }

    @PostMapping("/merge/university")
    public List<UnionUniversity> mergeUniversity() {
        return mergeUniversityService.merge();
    }
}
