package com.cdpo_spring_developer.tech_services.service;

import com.cdpo_spring_developer.tech_services.dto.ReservationPeriodDTO;
import com.cdpo_spring_developer.tech_services.dto.ReservationRequestDTO;
import com.cdpo_spring_developer.tech_services.entity.Reservations;
import com.cdpo_spring_developer.tech_services.mapper.ReservationMapper;
import com.cdpo_spring_developer.tech_services.repository.ReservationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationsService {
    private final ReservationsRepository reservationsRepository;
    private final ReservationMapper reservationMapperMapper;

    public List<ReservationRequestDTO> getAllReservations() {
        List<Reservations> reservations = reservationsRepository.getAllReservations();
        return reservations.stream().map(reservationMapperMapper::mapToDTO).toList();
    }

    public List<ReservationRequestDTO> getAllReservationsForPeriod(ReservationPeriodDTO periodRequest) {
        List<Reservations> reservations = reservationsRepository.findAllReservationsForPeriod(periodRequest.from(), periodRequest.to());
        return reservations.stream().map(reservationMapperMapper::mapToDTO).toList();
    }

    public List<ReservationRequestDTO> getReservationsTotalRevenueForPeriod(ReservationPeriodDTO periodRequest) {
        List<Reservations> reservations = reservationsRepository.findTotalRevenueForPeriod(periodRequest.from(), periodRequest.to());
        return reservations.stream().map(reservationMapperMapper::mapToDTO).toList();
    }
}
