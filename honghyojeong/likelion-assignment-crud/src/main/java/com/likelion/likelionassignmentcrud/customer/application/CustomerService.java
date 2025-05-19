package com.likelion.likelionassignmentcrud.customer.application;

import com.likelion.likelionassignmentcrud.customer.api.dto.request.CustomerSaveRequestDto;
import com.likelion.likelionassignmentcrud.customer.api.dto.response.CustomerInfoResponseDto;
import com.likelion.likelionassignmentcrud.customer.api.dto.response.CustomerListResponseDto;
import com.likelion.likelionassignmentcrud.customer.domain.Customer;
import com.likelion.likelionassignmentcrud.customer.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Transactional
    public void saveCustomer(CustomerSaveRequestDto customerSaveRequestDto) {
        Customer customer = Customer.builder()
                .name(customerSaveRequestDto.name())
                .birthdate(customerSaveRequestDto.birthdate())
                .membership(customerSaveRequestDto.membership())
                .build();
        customerRepository.save(customer);
    }

    public CustomerListResponseDto getCustomer() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerInfoResponseDto> customerInfoResponseDtoList = customers.stream()
                .map(CustomerInfoResponseDto::from)
                .toList();
        return CustomerListResponseDto.from(customerInfoResponseDtoList);
    }

    // 단일 사용자 조회
    public CustomerInfoResponseDto getOneCustomer(Long customerId) {
        Customer customer = customerRepository
                .findById(customerId)
                .orElseThrow(IllegalArgumentException::new);
        return CustomerInfoResponseDto.from(customer);
    }
}