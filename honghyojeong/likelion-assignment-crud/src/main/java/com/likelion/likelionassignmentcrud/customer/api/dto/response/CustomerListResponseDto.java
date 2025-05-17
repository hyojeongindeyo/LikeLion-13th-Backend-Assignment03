package com.likelion.likelionassignmentcrud.customer.api.dto.response;

import com.likelion.likelionassignmentcrud.customer.domain.Customer;
import lombok.Builder;

import java.util.List;

@Builder
public record CustomerListResponseDto(
        List<CustomerInfoResponseDto> customers
) {
    public static CustomerListResponseDto from(List<CustomerInfoResponseDto> customers) {
        return CustomerListResponseDto.builder()
                .customers(customers)
                .build();
    }
}
