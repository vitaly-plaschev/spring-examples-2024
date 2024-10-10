package com.cdpo_spring_developer.tech_services.repository;

import com.cdpo_spring_developer.tech_services.constants.ReservationStatus;
import com.cdpo_spring_developer.tech_services.dto.ReservationRequestDTO;
import com.cdpo_spring_developer.tech_services.dto.ReservationsResponseDTO;
import com.cdpo_spring_developer.tech_services.dto.TechServiceDTO;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationsRepository {
    private final List<ReservationsResponseDTO> list = new ArrayList<ReservationsResponseDTO>();

    private static int idCounter = 0;

    public static synchronized int createID()
    {
        return idCounter++;
    }

    public List<ReservationsResponseDTO> getAllServices() {
        if (list.isEmpty()) return List.of();
        return list;
    }

    public ReservationsResponseDTO findById(int id) {
        for (ReservationsResponseDTO res : list) {
            if (res.id() == id) {
                return res;
            }
        }
        return null;
    }

    public ReservationsResponseDTO save(ReservationRequestDTO res) {
        ReservationsResponseDTO r = new ReservationsResponseDTO(createID(), res.name(), res.registeredAt(), ReservationStatus.CREATED, LocalDateTime.now());
        list.add(r);
        return r;
    }

    public void delete(int id) {
        list.removeIf(e -> e.id() == id);
    }
}