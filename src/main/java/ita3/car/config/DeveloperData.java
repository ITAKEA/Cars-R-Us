package ita3.car.config;

import ita3.car.entity.Car;
import ita3.car.repository.ICarRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class DeveloperData implements ApplicationRunner {


    ICarRepository carrepo;

    public DeveloperData(ICarRepository carrepo) {
        this.carrepo = carrepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        carrepo.save(new Car("Volvo", "B4", 200, 12));
        carrepo.save(new Car("BMW", "320i", 240, 8));
        carrepo.save(new Car("Mercedes", "C200", 220, 9));
        carrepo.save(new Car("Audi", "A4", 210, 10));
        carrepo.save(new Car("Tesla", "Model 3", 260, 5));
        carrepo.save(new Car("Toyota", "Camry", 190, 11));
        carrepo.save(new Car("Honda", "Accord", 180, 10));
        carrepo.save(new Car("Ford", "Focus", 170, 9));
        carrepo.save(new Car("Chevrolet", "Malibu", 190, 11));
        carrepo.save(new Car("Hyundai", "Elantra", 180, 10));

    }
}
