package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "CONFERENCE", schema = "IFMO", catalog = "")
public class UnionConference {
    private long conferenceId;
    private String title;
    private String place;
    private Time conferenceDate;

    @Id
    @Column(name = "CONFERENCE_ID")
    public long getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(long conferenceId) {
        this.conferenceId = conferenceId;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "PLACE")
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Basic
    @Column(name = "CONFERENCE_DATE")
    public Time getConferenceDate() {
        return conferenceDate;
    }

    public void setConferenceDate(Time conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionConference that = (UnionConference) o;
        return conferenceId == that.conferenceId &&
                Objects.equals(title, that.title) &&
                Objects.equals(place, that.place) &&
                Objects.equals(conferenceDate, that.conferenceDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conferenceId, title, place, conferenceDate);
    }
}
