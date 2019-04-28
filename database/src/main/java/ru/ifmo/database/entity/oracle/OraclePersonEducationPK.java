package ru.ifmo.database.entity.oracle;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OraclePersonEducationPK implements Serializable {
    @Id
    @NotNull
    @Column(name = "work_id")
    private int personId;
    @Id
    @NotNull
    @Column(name = "discipline_id")
    private int educationId;
}
