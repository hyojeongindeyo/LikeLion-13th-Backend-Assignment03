package com.likelion.likelionassignmentcrud.reservation.api;

import com.likelion.likelionassignmentcrud.reservation.api.dto.request.ReservationSaveRequestDto;
import com.likelion.likelionassignmentcrud.reservation.api.dto.response.ReservationListResponseDto;
import com.likelion.likelionassignmentcrud.reservation.application.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping("/save")
    public ResponseEntity<String> reservationSave(@RequestBody ReservationSaveRequestDto reservationSaveRequestDto) {
        reservationService.reservationSave(reservationSaveRequestDto);
        return new ResponseEntity<>("예약 저장", HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<ReservationListResponseDto> myReservations(@PathVariable("customerId") Long customerId) {
        ReservationListResponseDto reservationListResponseDto = reservationService.reservationFindCustomer(customerId);
        return new ResponseEntity<>(reservationListResponseDto, HttpStatus.OK);
    }
}
