package com.likelion.likelionassignmentcrud.customer.api.dto.request;

import com.likelion.likelionassignmentcrud.customer.domain.Membership;

public record CustomerSaveRequestDto(
        String name,
        String birthdate,
        Membership membership
) {
}
