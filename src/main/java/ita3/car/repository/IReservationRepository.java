package ita3.car.repository;

import ita3.car.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}
