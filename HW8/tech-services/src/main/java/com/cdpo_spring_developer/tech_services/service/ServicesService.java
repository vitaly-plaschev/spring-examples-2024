package com.cdpo_spring_developer.tech_services.service;

import com.cdpo_spring_developer.tech_services.dto.ServiceRequestDTO;
import com.cdpo_spring_developer.tech_services.entity.Services;
import com.cdpo_spring_developer.tech_services.exceptions.CustomerException;
import com.cdpo_spring_developer.tech_services.mapper.ServiceMapper;
import com.cdpo_spring_developer.tech_services.repository.ServicesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ServicesService {
    private final ServicesRepository servicesRepository;
    private final ServiceMapper serviceMapper;

    public List<ServiceRequestDTO> getAllServices() {
        List<Services> customers = servicesRepository.getAllServices();
        if (customers.isEmpty()) throw new CustomerException(HttpStatus.NOT_FOUND, "Records not found");
        return customers.stream().map(serviceMapper::mapToDTO).toList();
    }

    public List<ServiceRequestDTO> getServiceByFilter(String name, Double price) {
        List<Services> services = servicesRepository.findByFilter(name, price);
        return services.stream().map(serviceMapper::mapToDTO).toList();
    }

    public Long registerService(ServiceRequestDTO serviceRequest) {
        try {
            Services service = serviceMapper.mapToEntity(serviceRequest);

            servicesRepository.save(service);

            return service.getId();
        } catch (CustomerException e) {
            throw new CustomerException(HttpStatus.INTERNAL_SERVER_ERROR, "Register of service is failed");
        }
    }

    public void deleteService(Long id) {
        try {
            servicesRepository.customDeleteService(id);
        } catch (CustomerException e) {
            throw new CustomerException(HttpStatus.INTERNAL_SERVER_ERROR, "Deletion of service is failed");
        }
    }

    public void updateService(Long id, ServiceRequestDTO customerRequest) {

        Optional<Services> optional = servicesRepository.findById(id);
        Services original;
        if (optional.isPresent()) {
            original = optional.get();
        } else {
            throw new CustomerException(HttpStatus.BAD_REQUEST, "ID is not found");
        }

        Services serviceToUpdate = serviceMapper.mapToEntity(customerRequest);
        String name = serviceToUpdate.getName();
        Double price = serviceToUpdate.getPrice();

        try {
            servicesRepository.customUpdateServices(id,
                    name == null || name.isEmpty() ? original.getName() : name,
                    price == null || price.isNaN() ? original.getPrice() : price);
        } catch (CustomerException e) {
            throw new CustomerException(HttpStatus.INTERNAL_SERVER_ERROR, "Deletion of service is failed");
        }
    }

}
