package ita3.car.api;

import ita3.car.entity.Car;
import ita3.car.entity.Reservation;
import ita3.car.repository.ICarRepository;
import ita3.car.repository.IReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ReservationController {

    IReservationRepository reservationRepository;
    ICarRepository carRepository;

    public ReservationController(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @PostMapping("/res")
    public ResponseEntity<Void> create(@RequestBody Reservation res){
        Optional<Car> car = carRepository.findById(res.getCar().getId());
        System.out.println(car);
        Reservation savedRes = reservationRepository.save(res);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
