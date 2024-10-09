package com.cdpo_spring_developer.tech_services.service;

import org.springframework.stereotype.Service;
import com.cdpo_spring_developer.tech_services.dto.TechServiceDTO;
import com.cdpo_spring_developer.tech_services.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TechServiceService {
    @Autowired
    private ServicesRepository servicesRepository;

    public List<TechServiceDTO> getAllServices() {
        return servicesRepository.getAllServices();
    }

    public TechServiceDTO findById(int id) {
        return servicesRepository.findById(id);
    }

    public TechServiceDTO save(TechServiceDTO techService) {
        return servicesRepository.save(techService);
    }

}
