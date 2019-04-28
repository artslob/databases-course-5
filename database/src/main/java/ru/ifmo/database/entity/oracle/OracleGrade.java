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
@Table(name = "GRADE", schema = "IFMO", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OracleGrade {
    @Id
    @Column(name = "grade_id")
    private int gradeId;
    @NotNull
    @Size(max = 1)
    private String letter;
    @NotNull
    @Column(name = "grade_date")
    private Date gradeDate;
    @NotNull
    @Column(name = "person_id")
    private int personId;
    @NotNull
    @Column(name = "discipline_id")
    private int disciplineId;
}
