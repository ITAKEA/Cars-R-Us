package ita3.car.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "car_brand", nullable = false, length = 50)
    private String brand;
    @Column(name = "car_model", nullable = false, length = 60)
    private String model;
    @Column(name= "rental_price_day")
    private double pricePrDay;
    @Column(name = "max_discount")
    private int bestDiscount;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime lastEdited;

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(LocalDateTime lastEdited) {
        this.lastEdited = lastEdited;
    }

    public Car() {}

    public Car(String brand, String model, double pricePrDay, int bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPricePrDay() {
        return pricePrDay;
    }

    public void setPricePrDay(double pricePrDay) {
        this.pricePrDay = pricePrDay;
    }

    public int getBestDiscount() {
        return bestDiscount;
    }

    public void setBestDiscount(int bestDiscount) {
        this.bestDiscount = bestDiscount;
    }
}
