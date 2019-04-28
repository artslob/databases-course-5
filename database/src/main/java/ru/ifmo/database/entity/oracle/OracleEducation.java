package ru.ifmo.database.entity.oracle;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "EDUCATION", schema = "IFMO", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OracleEducation {
    @Id
    @Column(name = "education_id")
    private int educationId;
    @NotNull
    @Size(max = 100)
    @Column(name = "education_type")
    private String educationType;
    @NotNull
    @Size(max = 100)
    @Column(name = "education_form")
    private String educationForm;
    @NotNull
    @Size(max = 100)
    private String qualification;
    @NotNull
    @Column(name = "start_date")
    private Date startDate;
    @NotNull
    @Column(name = "end_date")
    private Date endDate;
    private short course;
    @Column(name = "department_id")
    private int departmentId;
}
