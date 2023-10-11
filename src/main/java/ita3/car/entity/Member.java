package ita3.car.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zip;
    private boolean approved;
    private int ranking;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime lastEdited;

    @OneToMany(mappedBy = "member")
    private List<Reservation> reservations = new ArrayList<>();

    public Member() {}

    public Member(String user, String password, String email, String firstName,
                  String lastName, String street, String city, String zip) {
        this.username = user;
        this.password= password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

}
