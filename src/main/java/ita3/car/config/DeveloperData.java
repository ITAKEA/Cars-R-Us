package ita3.car.config;

import ita3.car.entity.Car;
import ita3.car.entity.Member;
import ita3.car.repository.ICarRepository;
import ita3.car.repository.IMemberRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class DeveloperData implements ApplicationRunner {

    ICarRepository repo;
    IMemberRepository member;

    public DeveloperData(ICarRepository repo, IMemberRepository member) {
        this.repo = repo;
        this.member  = member;

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        this.repo.save(new Car("Volvo", "XC90", 300, 15));
        this.repo.save(new Car("Audi", "A4", 250, 14));
        this.repo.save(new Car("BMW", "X5", 270, 13));
        this.repo.save(new Car("Toyota", "Corolla", 180, 16));
        this.repo.save(new Car("Ford", "Focus", 200, 15));
        this.repo.save(new Car("Mercedes-Benz", "C-Class", 290, 14));
        this.repo.save(new Car("Honda", "Civic", 190, 16));
        this.repo.save(new Car("Nissan", "Altima", 210, 15));
        this.repo.save(new Car("Chevrolet", "Impala", 220, 14));
        this.repo.save(new Car("Tesla", "Model 3", 310, 13));


        this.member.save(new Member("user1", "pass1234", "user1@example.com", "John", "Doe", "123 Main St", "Copenhagen", "1000"));
        this.member.save(new Member("user2", "pass5678", "user2@example.com", "Jane", "Smith", "456 Elm St", "Aarhus", "2000"));
        this.member.save(new Member("user3", "pass9101", "user3@example.com", "Brian", "Jones", "789 Pine St", "Odense", "3000"));
        this.member.save(new Member("user4", "pass1121", "user4@example.com", "Alice", "Johnson", "101 Maple St", "Aalborg", "4000"));
        this.member.save(new Member("user5", "pass3141", "user5@example.com", "Charlie", "Brown", "202 Oak St", "Esbjerg", "5000"));

    }

}


