package com.cdpo_spring_developer.tech_services.service;

import com.cdpo_spring_developer.tech_services.dto.ReservationRequestDTO;
import com.cdpo_spring_developer.tech_services.dto.ReservationUpdateDTO;
import com.cdpo_spring_developer.tech_services.dto.ReservationsResponseDTO;
import com.cdpo_spring_developer.tech_services.dto.TechServiceDTO;
import com.cdpo_spring_developer.tech_services.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsService {
    @Autowired
    private ReservationsRepository reservationsRepository;

    public List<ReservationsResponseDTO> getAllReservations() {
        return reservationsRepository.getAllReservations();
    }

    public ReservationsResponseDTO save(ReservationRequestDTO reservation) {
        return reservationsRepository.save(reservation);
    }

    public void delete(int id) {
        reservationsRepository.delete(id);
    }

    public void update(ReservationUpdateDTO reservation) {
        reservationsRepository.update(reservation);
    }

}
