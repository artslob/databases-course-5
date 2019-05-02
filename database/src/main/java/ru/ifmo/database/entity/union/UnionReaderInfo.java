package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "READER_INFO", schema = "IFMO", catalog = "")
public class UnionReaderInfo {
    @Basic
    @Column(name = "OBTAIN_DATE")
    private Time obtainDate;
    @Basic
    @Column(name = "RETURNED")
    private Time returned;
}
