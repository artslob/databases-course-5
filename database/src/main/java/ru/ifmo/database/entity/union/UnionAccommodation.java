package ru.ifmo.database.entity.union;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "ACCOMMODATION", schema = "IFMO", catalog = "")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UnionAccommodation {
    @Id
    @Column(name = "ACCOMMODATION_ID")
    private long accommodationId;
    @Basic
    @Column(name = "ACC_FROM")
    private Time accFrom;
    @Basic
    @Column(name = "ACC_TO")
    private Time accTo;
    @Basic
    @Column(name = "EXEMPTION")
    private long exemption;
}
