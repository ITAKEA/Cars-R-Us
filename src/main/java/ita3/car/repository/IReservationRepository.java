package ita3.car.repository;

import ita3.car.entity.Car;
import ita3.car.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCarAndRetalDate(Car car, LocalDate retalDate);
}
