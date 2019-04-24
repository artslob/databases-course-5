package ru.ifmo.database.entity.mysql.generated;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "conference", schema = "ifmo_hibd", catalog = "")
public class MySQLConference {
    private int conferenceId;
    private String title;
    private String place;
    private Date date;
    private Collection<MySQLConferenceParticipants> conferenceParticipantsByConferenceId;

    @Id
    @Column(name = "conference_id", nullable = false)
    public int getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "place", nullable = false, length = 100)
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySQLConference that = (MySQLConference) o;
        return conferenceId == that.conferenceId &&
                Objects.equals(title, that.title) &&
                Objects.equals(place, that.place) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conferenceId, title, place, date);
    }

    @OneToMany(mappedBy = "conferenceByConferenceId")
    public Collection<MySQLConferenceParticipants> getConferenceParticipantsByConferenceId() {
        return conferenceParticipantsByConferenceId;
    }

    public void setConferenceParticipantsByConferenceId(Collection<MySQLConferenceParticipants> conferenceParticipantsByConferenceId) {
        this.conferenceParticipantsByConferenceId = conferenceParticipantsByConferenceId;
    }
}
