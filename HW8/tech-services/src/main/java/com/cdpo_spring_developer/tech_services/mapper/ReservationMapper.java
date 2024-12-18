package com.cdpo_spring_developer.tech_services.mapper;

import com.cdpo_spring_developer.tech_services.dto.ReservationRequestDTO;
import com.cdpo_spring_developer.tech_services.entity.Reservations;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapper {
    public Reservations mapToEntity(ReservationRequestDTO reservationRequest) {
        return Reservations.builder()
                .orderId(reservationRequest.orderId())
                .customerName(reservationRequest.customerName())
                .serviceName(reservationRequest.serviceName())
                .date(reservationRequest.date())
                .price(reservationRequest.price())
                .isCompleted(reservationRequest.isCompleted())
                .totalAmount(reservationRequest.totalAmount())
                .build();
    }

    public ReservationRequestDTO mapToDTO(Reservations reservations) {
        return new ReservationRequestDTO(
                reservations.getOrderId(),
                reservations.getCustomerName(),
                reservations.getServiceName(),
                reservations.getDate(),
                reservations.getPrice(),
                reservations.isCompleted(),
                reservations.getTotalAmount()
        );
    }
}