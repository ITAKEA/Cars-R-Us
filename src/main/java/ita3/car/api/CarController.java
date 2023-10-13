package ita3.car.api;

import ita3.car.entity.Car;
import ita3.car.repository.ICarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    ICarRepository carRepository;

    public CarController(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }


    // READ-ALL -> get
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars(){
        return ResponseEntity.ok().body(carRepository.findAll());
    }

    // READ -> Get
    @GetMapping("/cars/{id}")
    public ResponseEntity<Optional<Car>> getOneCar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(carRepository.findById(id));
    }

    // CREATE -> POST
    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        Car savedCar = carRepository.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }

    // UPDATE -> PUT
    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car){
        if(!carRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Car updatedCar = carRepository.save(car);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCar);
    }
    // DELETE -> Delete

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id){
        if(!carRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        carRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
