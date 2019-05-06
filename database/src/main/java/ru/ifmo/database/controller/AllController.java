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
    private final MergeEducationService mergeEducationService;
    private final MergeWorkService mergeWorkService;
    private final MergeWorkDisciplineService mergeWorkDisciplineService;
    private final MergeScheduleService mergeScheduleService;
    private final MergeReaderListService mergeReaderListService;
    private final MergeBookService mergeBookService;
    private final MergeReaderInfoService mergeReaderInfoService;
    private final MergeConferenceService mergeConferenceService;
    private final MergeConferenceParticipantsService mergeConferenceParticipantsService;
    private final MergeProjectService mergeProjectService;
    private final MergeProjectParticipantsService mergeProjectParticipantsService;
    private final MergePublicationService mergePublicationService;
    private final MergePublicationCoauthorsService mergePublicationCoauthorsService;
    private final MergeEditionService mergeEditionService;
    private final MergeHostelService mergeHostelService;

    public AllController(MergePersonService mergePersonService,
                         MergeUniversityService mergeUniversityService,
                         MergeDepartmentService mergeDepartmentService,
                         MergeSpecialityService mergeSpecialityService,
                         MergeDisciplineService mergeDisciplineService,
                         MergeGradeService mergeGradeService,
                         MergeEducationService mergeEducationService,
                         MergeWorkService mergeWorkService,
                         MergeWorkDisciplineService mergeWorkDisciplineService,
                         MergeScheduleService mergeScheduleService,
                         MergeReaderListService mergeReaderListService,
                         MergeBookService mergeBookService,
                         MergeReaderInfoService mergeReaderInfoService,
                         MergeConferenceService mergeConferenceService,
                         MergeConferenceParticipantsService mergeConferenceParticipantsService,
                         MergeProjectService mergeProjectService,
                         MergeProjectParticipantsService mergeProjectParticipantsService,
                         MergePublicationService mergePublicationService,
                         MergePublicationCoauthorsService mergePublicationCoauthorsService,
                         MergeEditionService mergeEditionService, MergeHostelService mergeHostelService) {
        this.mergePersonService = mergePersonService;
        this.mergeUniversityService = mergeUniversityService;
        this.mergeDepartmentService = mergeDepartmentService;
        this.mergeSpecialityService = mergeSpecialityService;
        this.mergeDisciplineService = mergeDisciplineService;
        this.mergeGradeService = mergeGradeService;
        this.mergeEducationService = mergeEducationService;
        this.mergeWorkService = mergeWorkService;
        this.mergeWorkDisciplineService = mergeWorkDisciplineService;
        this.mergeScheduleService = mergeScheduleService;
        this.mergeReaderListService = mergeReaderListService;
        this.mergeBookService = mergeBookService;
        this.mergeReaderInfoService = mergeReaderInfoService;
        this.mergeConferenceService = mergeConferenceService;
        this.mergeConferenceParticipantsService = mergeConferenceParticipantsService;
        this.mergeProjectService = mergeProjectService;
        this.mergeProjectParticipantsService = mergeProjectParticipantsService;
        this.mergePublicationService = mergePublicationService;
        this.mergePublicationCoauthorsService = mergePublicationCoauthorsService;
        this.mergeEditionService = mergeEditionService;
        this.mergeHostelService = mergeHostelService;
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
            mergeEducation();
            mergeWork();
            mergeWorkDiscipline();
            mergeSchedule();
            mergeReaderList();
            mergeBook();
            mergeReaderInfo();
            mergeConference();
            mergeConferenceParticipants();
            mergeProject();
            mergeProjectParticipants();
            mergePublication();
            mergePublicationCoauthors();
            mergeEdition();
            mergeHostel();
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

    @PostMapping("/merge/education")
    public List<UnionEducation> mergeEducation() {
        return mergeEducationService.merge();
    }

    @PostMapping("/merge/work")
    public List<UnionWork> mergeWork() {
        return mergeWorkService.merge();
    }

    @PostMapping("/merge/work-discipline")
    public List<UnionWorkDiscipline> mergeWorkDiscipline() {
        return mergeWorkDisciplineService.merge();
    }

    @PostMapping("/merge/schedule")
    public List<UnionSchedule> mergeSchedule() {
        return mergeScheduleService.merge();
    }

    @PostMapping("/merge/reader-list")
    public List<UnionReaderList> mergeReaderList() {
        return mergeReaderListService.merge();
    }

    @PostMapping("/merge/book")
    public List<UnionBook> mergeBook() {
        return mergeBookService.merge();
    }

    @PostMapping("/merge/reader-info")
    public List<UnionReaderInfo> mergeReaderInfo() {
        return mergeReaderInfoService.merge();
    }

    @PostMapping("/merge/conference")
    public List<UnionConference> mergeConference() {
        return mergeConferenceService.merge();
    }

    @PostMapping("/merge/conference-participants")
    public List<UnionConferenceParticipants> mergeConferenceParticipants() {
        return mergeConferenceParticipantsService.merge();
    }

    @PostMapping("/merge/project")
    public List<UnionProject> mergeProject() {
        return mergeProjectService.merge();
    }

    @PostMapping("/merge/project-participants")
    public List<UnionProjectParticipants> mergeProjectParticipants() {
        return mergeProjectParticipantsService.merge();
    }

    @PostMapping("/merge/publication")
    public List<UnionPublication> mergePublication() {
        return mergePublicationService.merge();
    }

    @PostMapping("/merge/publication-coauthors")
    public List<UnionPublicationCoauthors> mergePublicationCoauthors() {
        return mergePublicationCoauthorsService.merge();
    }

    @PostMapping("/merge/edition")
    public List<UnionEdition> mergeEdition() {
        return mergeEditionService.merge();
    }

    @PostMapping("/merge/hostel")
    public List<UnionHostel> mergeHostel() {
        return mergeHostelService.merge();
    }

}
