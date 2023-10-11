package ita3.car.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime reservationDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime retalDate;

    @ManyToOne
    Car car;

    @ManyToOne
    Member member;

    public Reservation() {
    }

    public Reservation(LocalDateTime retalDate, Car car, Member member) {
        this.retalDate = retalDate;
        this.car = car;
        this.member = member;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDateTime getRetalDate() {
        return retalDate;
    }

    public void setRetalDate(LocalDateTime retalDate) {
        this.retalDate = retalDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
