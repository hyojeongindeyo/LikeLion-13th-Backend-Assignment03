package com.likelion.likelionassignmentcrud.reservation.api.dto.response;

import com.likelion.likelionassignmentcrud.reservation.domain.Reservation;
import lombok.Builder;

@Builder
public record ReservationInfoResponseDto(
        String movie_title,
        String seat_number,
        String attendee
) {
    public static ReservationInfoResponseDto from(Reservation reservation) {
        return ReservationInfoResponseDto.builder()
                .movie_title(reservation.getMovie_title())
                .seat_number(reservation.getSeat_number())
                .attendee(reservation.getCustomer().getName())
                .build();
    }
}
