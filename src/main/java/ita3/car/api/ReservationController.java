package ita3.car.api;

import ita3.car.dto.ReservationRequest;
import ita3.car.entity.Car;
import ita3.car.entity.Member;
import ita3.car.entity.Reservation;
import ita3.car.repository.ICarRepository;
import ita3.car.repository.IMemberRepository;
import ita3.car.repository.IReservationRepository;
import ita3.car.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    IReservationRepository reservationRepository;
    ICarRepository carRepository;
    IMemberRepository memberRepository;
    ReservationService reservationService;

    public ReservationController(IReservationRepository reservationRepository, ICarRepository carRepository, IMemberRepository memberRepository, ReservationService reservationService) {
        this.reservationRepository = reservationRepository;
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
        this.reservationService = reservationService;
    }

    // READ-ALL -> get
    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getAllReservations(){
        return ResponseEntity.ok().body(reservationRepository.findAll());
    }

    // READ -> Get
    @GetMapping("/reservations/{id}")
    public ResponseEntity<Optional<Reservation>> getOneReservation(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(reservationRepository.findById(id));
    }

    // CREATE -> POST
    @PostMapping("/reservations")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequest request) {
        try {
            Reservation savedReservation = reservationService.createReservation(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedReservation);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null); // 409 Conflict
        }
    }

    // UPDATE -> PUT
    @PutMapping("/reservations/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation){
        if(!reservationRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Reservation updatedReservation = reservationRepository.save(reservation);
        return ResponseEntity.status(HttpStatus.OK).body(updatedReservation);
    }

    // DELETE -> Delete
    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id){
        if(!reservationRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        reservationRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
