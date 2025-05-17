package com.likelion.likelionassignmentcrud.reservation.api.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record ReservationListResponseDto(
        List<ReservationInfoResponseDto> reservations
) {
    public static ReservationListResponseDto from (List<ReservationInfoResponseDto> reservations) {
        return ReservationListResponseDto.builder()
                .reservations(reservations)
                .build();

    }
}
