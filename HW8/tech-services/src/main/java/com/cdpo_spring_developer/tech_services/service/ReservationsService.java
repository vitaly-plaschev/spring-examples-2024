package com.cdpo_spring_developer.tech_services.service;

import com.cdpo_spring_developer.tech_services.dto.OrderRequestDTO;
import com.cdpo_spring_developer.tech_services.dto.ReservationRequestDTO;
import com.cdpo_spring_developer.tech_services.entity.Orders;
import com.cdpo_spring_developer.tech_services.entity.Reservations;
import com.cdpo_spring_developer.tech_services.mapper.OrderMapper;
import com.cdpo_spring_developer.tech_services.mapper.ReservationMapper;
import com.cdpo_spring_developer.tech_services.repository.OrdersRepository;
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
}
