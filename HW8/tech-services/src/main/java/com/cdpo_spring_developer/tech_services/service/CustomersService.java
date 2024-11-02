package com.cdpo_spring_developer.tech_services.service;

import com.cdpo_spring_developer.tech_services.dto.CustomerRequestDTO;
import com.cdpo_spring_developer.tech_services.entity.Customers;
import com.cdpo_spring_developer.tech_services.exceptions.CustomerException;
import com.cdpo_spring_developer.tech_services.mapper.CustomerMapper;
import com.cdpo_spring_developer.tech_services.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomersService {

    private final CustomersRepository customersRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerRequestDTO> getAllCustomers() {
        List<Customers> customers = customersRepository.getAllCustomers();
        if (customers.isEmpty()) throw new CustomerException(HttpStatus.NOT_FOUND, "Records not found");
        return customers.stream().map(customerMapper::mapToDTO).toList();
    }

    public CustomerRequestDTO getCustomerById(long id) {
        Customers customers = customersRepository.findById(id)
                .orElseThrow(() -> new CustomerException(HttpStatus.NOT_FOUND, "Record not found"));

        return customerMapper.mapToDTO(customers);
    }
}
