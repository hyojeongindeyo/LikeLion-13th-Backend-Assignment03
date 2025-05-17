package com.likelion.likelionassignmentcrud.customer.domain;

import com.likelion.likelionassignmentcrud.reservation.domain.Reservation;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    private String name;

    private String birthdate;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Membership membership;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    @Builder
    private Customer(String name, String birthdate, Membership membership) {
        this.name = name;
        this.birthdate = birthdate;
        this.membership = membership;
    }
}