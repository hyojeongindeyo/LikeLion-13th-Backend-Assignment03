package com.likelion.likelionassignmentcrud.customer.domain.repository;

import com.likelion.likelionassignmentcrud.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
