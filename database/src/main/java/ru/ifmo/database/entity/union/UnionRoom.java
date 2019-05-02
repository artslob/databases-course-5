package ru.ifmo.database.entity.union;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ROOM", schema = "IFMO", catalog = "")
public class UnionRoom {
    private long roomId;
    private long roomNumber;
    private long capacity;
    private long payment;
    private long insects;

    @Id
    @Column(name = "ROOM_ID")
    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "ROOM_NUMBER")
    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Basic
    @Column(name = "CAPACITY")
    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "PAYMENT")
    public long getPayment() {
        return payment;
    }

    public void setPayment(long payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "INSECTS")
    public long getInsects() {
        return insects;
    }

    public void setInsects(long insects) {
        this.insects = insects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnionRoom unionRoom = (UnionRoom) o;
        return roomId == unionRoom.roomId &&
                roomNumber == unionRoom.roomNumber &&
                capacity == unionRoom.capacity &&
                payment == unionRoom.payment &&
                insects == unionRoom.insects;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, roomNumber, capacity, payment, insects);
    }
}
