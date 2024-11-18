package com.cdpo_spring_developer.tech_services.service;

import com.cdpo_spring_developer.tech_services.dto.CustomerRequestDTO;
import com.cdpo_spring_developer.tech_services.entity.Customers;
import com.cdpo_spring_developer.tech_services.exceptions.CustomerException;
import com.cdpo_spring_developer.tech_services.mapper.CustomerMapper;
import com.cdpo_spring_developer.tech_services.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<CustomerRequestDTO> getCustomerByName(String name) {
        List<Customers> customers = customersRepository.findAllByName(name);
        return customers.stream().map(customerMapper::mapToDTO).toList();
    }

    public List<CustomerRequestDTO> getCustomerByMobile(String mobile) {
        List<Customers> customers = customersRepository.findAllByMobile(mobile);
        return customers.stream().map(customerMapper::mapToDTO).toList();
    }

    public List<CustomerRequestDTO> getCustomerByFilter(String name, String mobile) {
        List<Customers> customers = customersRepository.findByFilter(name, mobile);
        return customers.stream().map(customerMapper::mapToDTO).toList();
    }

    public Long registerCustomer(CustomerRequestDTO customerRequest) {
        try {
            Customers customer = customerMapper.mapToEntity(customerRequest);

            customersRepository.save(customer);

            return customer.getId();

        } catch (CustomerException e) {
            throw new CustomerException(HttpStatus.INTERNAL_SERVER_ERROR, "Customer register is failed");
        }
    }

    public void deleteCustomer(Long id) {
        try {
            customersRepository.customDeleteCustomer(id);
        } catch (CustomerException e) {
            throw new CustomerException(HttpStatus.INTERNAL_SERVER_ERROR, "Deletion of customer is failed");
        }
    }

    public void updateCustomer(Long id, CustomerRequestDTO customerRequest) {

        Optional<Customers> optional = customersRepository.findById(id);
        Customers original;
        if (optional.isPresent()) {
            original = optional.get();
        } else {
            throw new CustomerException(HttpStatus.BAD_REQUEST, "ID is not found");
        }

        Customers customerToUpdate = customerMapper.mapToEntity(customerRequest);
        String name = customerToUpdate.getName();
        String mobile = customerToUpdate.getMobile();

        try {
            customersRepository.customUpdateCustomer(id,
                    name == null || name.isEmpty() ? original.getName() : name,
                    mobile == null || mobile.isEmpty() ? original.getMobile() : mobile);
        } catch (CustomerException e) {
            throw new CustomerException(HttpStatus.INTERNAL_SERVER_ERROR, "Update of customer is failed");
        }
    }
}
