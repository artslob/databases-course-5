package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "WARNING", schema = "IFMO", catalog = "")
public class UnionWarning {
    private long warningId;
    private Time warningDate;
    private String warnText;

    @Id
    @Column(name = "WARNING_ID")
    public long getWarningId() {
        return warningId;
    }

    public void setWarningId(long warningId) {
        this.warningId = warningId;
    }

    @Basic
    @Column(name = "WARNING_DATE")
    public Time getWarningDate() {
        return warningDate;
    }

    public void setWarningDate(Time warningDate) {
        this.warningDate = warningDate;
    }

    @Basic
    @Column(name = "WARN_TEXT")
    public String getWarnText() {
        return warnText;
    }

    public void setWarnText(String warnText) {
        this.warnText = warnText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionWarning that = (UnionWarning) o;
        return warningId == that.warningId &&
                Objects.equals(warningDate, that.warningDate) &&
                Objects.equals(warnText, that.warnText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warningId, warningDate, warnText);
    }
}
