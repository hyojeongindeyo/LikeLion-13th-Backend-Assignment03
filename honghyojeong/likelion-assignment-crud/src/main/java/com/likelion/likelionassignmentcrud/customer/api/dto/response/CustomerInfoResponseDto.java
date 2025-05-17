package com.likelion.likelionassignmentcrud.customer.api.dto.response;

import com.likelion.likelionassignmentcrud.customer.domain.Customer;
import com.likelion.likelionassignmentcrud.customer.domain.Membership;
import lombok.Builder;

@Builder
public record CustomerInfoResponseDto(
        String name,
        String birthdate,
        Membership membership
) {
    public static CustomerInfoResponseDto from(Customer customer) {
        return CustomerInfoResponseDto.builder()
                .name(customer.getName())
                .birthdate(customer.getBirthdate())
                .membership(customer.getMembership())
                .build();
    }
}
