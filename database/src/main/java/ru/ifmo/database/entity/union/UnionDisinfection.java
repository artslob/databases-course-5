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
@Table(name = "DISINFECTION", schema = "IFMO", catalog = "")
public class UnionDisinfection {
    @Id
    @Column(name = "DISINFECTION_ID")
    private long disinfectionId;
    @Basic
    @Column(name = "DISINFECTION_DATE")
    private Time disinfectionDate;
}
