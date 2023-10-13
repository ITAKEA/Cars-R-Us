package ita3.car.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ReservationRequest {

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate retalDate;
    private Long carId;
    private String memberId;

    public LocalDate getRetalDate() {
        return retalDate;
    }

    public void setRetalDate(LocalDate retalDate) {
        this.retalDate = retalDate;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}

