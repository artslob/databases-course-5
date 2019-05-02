package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "WARNING", schema = "IFMO", catalog = "")
public class UnionWarning {
    @Id
    @Column(name = "WARNING_ID")
    private long warningId;
    @Basic
    @Column(name = "WARNING_DATE")
    private Time warningDate;
    @Basic
    @Column(name = "WARN_TEXT")
    private String warnText;
}
