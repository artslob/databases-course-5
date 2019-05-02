package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "HOSTEL", schema = "IFMO", catalog = "")
public class UnionHostel {
    private long hostelId;
    private String address;
    private long rooms;

    @Id
    @Column(name = "HOSTEL_ID")
    public long getHostelId() {
        return hostelId;
    }

    public void setHostelId(long hostelId) {
        this.hostelId = hostelId;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "ROOMS")
    public long getRooms() {
        return rooms;
    }

    public void setRooms(long rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionHostel that = (UnionHostel) o;
        return hostelId == that.hostelId &&
                rooms == that.rooms &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostelId, address, rooms);
    }
}
