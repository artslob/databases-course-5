package ru.ifmo.database.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.database.entity.union.*;
import ru.ifmo.database.etl.impl.*;

import java.util.List;

@RestController
@RequestMapping("/all")
public class AllController {

    private final MergePersonService mergePersonService;
    private final MergeUniversityService mergeUniversityService;
    private final MergeDepartmentService mergeDepartmentService;
    private final MergeSpecialityService mergeSpecialityService;
    private final MergeDisciplineService mergeDisciplineService;
    private final MergeGradeService mergeGradeService;

    public AllController(MergePersonService mergePersonService, MergeUniversityService mergeUniversityService, MergeDepartmentService mergeDepartmentService, MergeSpecialityService mergeSpecialityService, MergeDisciplineService mergeDisciplineService, MergeGradeService mergeGradeService) {
        this.mergePersonService = mergePersonService;
        this.mergeUniversityService = mergeUniversityService;
        this.mergeDepartmentService = mergeDepartmentService;
        this.mergeSpecialityService = mergeSpecialityService;
        this.mergeDisciplineService = mergeDisciplineService;
        this.mergeGradeService = mergeGradeService;
    }

    @PostMapping("/merge/all")
    public String mergeAll() {
        try {
            mergePerson();
            mergeUniversity();
            mergeDepartment();
            mergeSpeciality();
            mergeDiscipline();
            mergeGrade();
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

    @PostMapping("/merge/discipline")
    public List<UnionDiscipline> mergeDiscipline() {
        return mergeDisciplineService.merge();
    }

    @PostMapping("/merge/grade")
    public List<UnionGrade> mergeGrade() {
        return mergeGradeService.merge();
    }
}
