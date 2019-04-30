package ru.ifmo.database.entity.mysql;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "project", schema = "ifmo_hibd", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MySQLProject {
    @Id
    @Column(name = "project_id", nullable = false)
    private int projectId;
    @Basic
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Basic
    @Column(name = "project_start", nullable = false)
    private Date projectStart;
    @Basic
    @Column(name = "project_end", nullable = false)
    private Date projectEnd;
}
