package com.likelion.likelionassignmentcrud.reservation.domain.repository;

import com.likelion.likelionassignmentcrud.customer.domain.Customer;
import com.likelion.likelionassignmentcrud.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCustomer(Customer customer);
}
