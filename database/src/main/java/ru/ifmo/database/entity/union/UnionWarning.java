package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "WARNING")
public class UnionWarning {
    @Id
    @Column(name = "WARNING_ID")
    private int warningId;
    @Basic
    @Column(name = "WARNING_DATE", nullable = false)
    private Date warningDate;
    @Basic
    @Column(name = "WARN_TEXT", length = 500)
    private String warnText;
    @Column(name = "accommodation_id")
    private int accommodationId;
}
