package ita3.car.service;

import ita3.car.dto.ReservationRequest;
import ita3.car.entity.Car;
import ita3.car.entity.Member;
import ita3.car.entity.Reservation;
import ita3.car.repository.ICarRepository;
import ita3.car.repository.IMemberRepository;
import ita3.car.repository.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {


    private ICarRepository carRepository;
    private IMemberRepository memberRepository;
    private IReservationRepository reservationRepository;

    public ReservationService(ICarRepository carRepository, IMemberRepository memberRepository, IReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(ReservationRequest request) {
        Car car = carRepository.findById(request.getCarId()).orElse(null);
        Member member = memberRepository.findById(request.getMemberId()).orElse(null);

        if (car == null || member == null) {
            throw new IllegalArgumentException("Invalid car or member ID");
        }

        // Check if the desired reservation date is in the past
        if (request.getRetalDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Cannot reserve for a date in the past");
        }

        // Check if the car is already reserved for the given date
        List<Reservation> existingReservations = reservationRepository.findByCarAndRetalDate(car, request.getRetalDate());
        if (!existingReservations.isEmpty()) {
            throw new IllegalStateException("Car is already reserved for the given date");
        }

        Reservation newReservation = new Reservation(request.getRetalDate(), car, member);
        return reservationRepository.save(newReservation);
    }

}

