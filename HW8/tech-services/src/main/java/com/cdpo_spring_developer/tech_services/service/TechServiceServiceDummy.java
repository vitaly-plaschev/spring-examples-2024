package com.cdpo_spring_developer.tech_services.service;

import org.springframework.stereotype.Service;
import com.cdpo_spring_developer.tech_services.dto.TechServiceDTO;
import com.cdpo_spring_developer.tech_services.repository.ServicesRepositoryDummy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TechServiceServiceDummy {
    @Autowired
    private ServicesRepositoryDummy servicesRepositoryDummy;

    public List<TechServiceDTO> getAllServices() {
        return servicesRepositoryDummy.getAllServices();
    }

    public TechServiceDTO findById(int id) {
        return servicesRepositoryDummy.findById(id);
    }

    public TechServiceDTO save(TechServiceDTO techService) {
        return servicesRepositoryDummy.save(techService);
    }

}
