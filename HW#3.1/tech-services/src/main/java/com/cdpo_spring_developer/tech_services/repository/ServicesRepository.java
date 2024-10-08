package com.cdpo_spring_developer.tech_services.repository;

import com.cdpo_spring_developer.tech_services.dto.TechServiceDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServicesRepository {
    private final List<TechServiceDTO> list = new ArrayList<TechServiceDTO>();

    public List<TechServiceDTO> getAllServices() {
        return list;
    }

    public TechServiceDTO findById(int id) {
        for (TechServiceDTO service : list) {
            if (service.getId() == id) {
                return service;
            }
        }
        return null;
    }

    public TechServiceDTO save(TechServiceDTO service) {
        TechServiceDTO c = new TechServiceDTO();
        c.setId(service.getId());
        c.setName(service.getName());
        list.add(c);
        return c;
    }
}
