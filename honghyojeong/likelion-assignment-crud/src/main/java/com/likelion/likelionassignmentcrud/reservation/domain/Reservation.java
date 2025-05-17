package com.likelion.likelionassignmentcrud.reservation.domain;


import com.likelion.likelionassignmentcrud.customer.domain.Customer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservation_id")
    private Long reservationId;

    private String movie_title;

    private String seat_number;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Builder
    private Reservation(String movie_title, String seat_number, Customer customer) {
        this.movie_title = movie_title;
        this.seat_number = seat_number;
        this.customer = customer;
    }

}
