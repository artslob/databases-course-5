package ru.ifmo.database.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.database.entity.union.UnionDepartment;
import ru.ifmo.database.entity.union.UnionPerson;
import ru.ifmo.database.entity.union.UnionSpeciality;
import ru.ifmo.database.entity.union.UnionUniversity;
import ru.ifmo.database.etl.impl.MergeDepartmentService;
import ru.ifmo.database.etl.impl.MergePersonService;
import ru.ifmo.database.etl.impl.MergeSpecialityService;
import ru.ifmo.database.etl.impl.MergeUniversityService;

import java.util.List;

@RestController
@RequestMapping("/all")
public class AllController {

    private final MergePersonService mergePersonService;
    private final MergeUniversityService mergeUniversityService;
    private final MergeDepartmentService mergeDepartmentService;
    private final MergeSpecialityService mergeSpecialityService;

    public AllController(MergePersonService mergePersonService, MergeUniversityService mergeUniversityService, MergeDepartmentService mergeDepartmentService, MergeSpecialityService mergeSpecialityService) {
        this.mergePersonService = mergePersonService;
        this.mergeUniversityService = mergeUniversityService;
        this.mergeDepartmentService = mergeDepartmentService;
        this.mergeSpecialityService = mergeSpecialityService;
    }

    @PostMapping("/merge/all")
    public String mergeAll() {
        try {
            mergePerson();
            mergeUniversity();
            mergeDepartment();
            mergeSpeciality();
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

    @PostMapping("/merge/speciality")
    public List<UnionSpeciality> mergeSpeciality() {
        return mergeSpecialityService.merge();
    }

}
