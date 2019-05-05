package ru.ifmo.database.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.database.entity.union.UnionDepartment;
import ru.ifmo.database.entity.union.UnionPerson;
import ru.ifmo.database.entity.union.UnionUniversity;
import ru.ifmo.database.etl.impl.MergeDepartmentService;
import ru.ifmo.database.etl.impl.MergePersonService;
import ru.ifmo.database.etl.impl.MergeUniversityService;

import java.util.List;

@RestController
@RequestMapping("/all")
public class AllController {

    private final MergePersonService mergePersonService;
    private final MergeUniversityService mergeUniversityService;
    private final MergeDepartmentService mergeDepartmentService;

    public AllController(MergePersonService mergePersonService, MergeUniversityService mergeUniversityService, MergeDepartmentService mergeDepartmentService) {
        this.mergePersonService = mergePersonService;
        this.mergeUniversityService = mergeUniversityService;
        this.mergeDepartmentService = mergeDepartmentService;
    }

    @PostMapping("/merge/all")
    public String mergeAll() {
        try {
            mergePerson();
            mergeUniversity();
            mergeDepartment();
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

    @PostMapping("/merge/department")
    public List<UnionDepartment> mergeDepartment() {
        return mergeDepartmentService.merge();
    }
}
