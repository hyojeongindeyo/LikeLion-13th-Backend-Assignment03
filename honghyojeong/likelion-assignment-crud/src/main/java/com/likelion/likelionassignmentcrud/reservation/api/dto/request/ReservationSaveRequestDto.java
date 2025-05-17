package com.likelion.likelionassignmentcrud.reservation.api.dto.request;

public record ReservationSaveRequestDto(
        Long customerId,
        String movie_title,
        String seat_number
) {
}
