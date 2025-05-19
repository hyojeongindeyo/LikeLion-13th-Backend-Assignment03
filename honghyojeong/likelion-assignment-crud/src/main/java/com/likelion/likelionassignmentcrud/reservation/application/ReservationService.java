package com.likelion.likelionassignmentcrud.reservation.application;

import com.likelion.likelionassignmentcrud.customer.domain.Customer;
import com.likelion.likelionassignmentcrud.customer.domain.repository.CustomerRepository;
import com.likelion.likelionassignmentcrud.reservation.api.dto.request.ReservationSaveRequestDto;
import com.likelion.likelionassignmentcrud.reservation.api.dto.response.ReservationInfoResponseDto;
import com.likelion.likelionassignmentcrud.reservation.api.dto.response.ReservationListResponseDto;
import com.likelion.likelionassignmentcrud.reservation.domain.Reservation;
import com.likelion.likelionassignmentcrud.reservation.domain.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class ReservationService {
    private final CustomerRepository customerRepository;
    private final ReservationRepository reservationRepository;

    @Transactional
    public void saveReservation(ReservationSaveRequestDto reservationSaveRequestDto) {
        Customer customer = customerRepository.findById(reservationSaveRequestDto.customerId())
                .orElseThrow(IllegalArgumentException::new);

        Reservation reservation = Reservation.builder()
                .movie_title(reservationSaveRequestDto.movie_title())
                .seat_number(reservationSaveRequestDto.seat_number())
                .customer(customer)
                .build();
        reservationRepository.save(reservation);
    }

    public ReservationListResponseDto reservationFindCustomer (Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(IllegalArgumentException::new);
        List<Reservation> reservations = reservationRepository.findByCustomer(customer);
        List<ReservationInfoResponseDto> reservationInfoResponseDtos = reservations.stream()
                .map(ReservationInfoResponseDto::from)
                .toList();
        return ReservationListResponseDto.from(reservationInfoResponseDtos);
    }

}
