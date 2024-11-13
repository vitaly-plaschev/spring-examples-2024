package com.cdpo_spring_developer.tech_services.service;

import com.cdpo_spring_developer.tech_services.dto.OrderRequestDTO;
import com.cdpo_spring_developer.tech_services.dto.ReservationRequestDTO;
import com.cdpo_spring_developer.tech_services.entity.Orders;
import com.cdpo_spring_developer.tech_services.exceptions.CustomerException;
import com.cdpo_spring_developer.tech_services.mapper.OrderMapper;
import com.cdpo_spring_developer.tech_services.mapper.ReservationMapper;
import com.cdpo_spring_developer.tech_services.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final OrderMapper orderMapper;

    public List<OrderRequestDTO> getAllOrders() {
        List<Orders> orders = ordersRepository.getAllOrders();
        return orders.stream().map(orderMapper::mapToDTO).toList();
    }

    public List<OrderRequestDTO> getOrderByFilter(Long customerId, Long serviceId) {
        List<Orders> orders = ordersRepository.findByFilter(customerId, serviceId);
        return orders.stream().map(orderMapper::mapToDTO).toList();
    }

    public void registerOrder(OrderRequestDTO orderRequest) {
        try {
            Orders order = orderMapper.mapToEntity(orderRequest);
            ordersRepository.customRegisterOrder(order.getDate(), order.getCustomerId(), order.getServiceId());
        } catch (CustomerException e) {
            throw new CustomerException(HttpStatus.INTERNAL_SERVER_ERROR, "Deletion of order is failed");
        }
    }

    public void completeOrder(Long id) {
        try {
            ordersRepository.completeOrder(id);
        } catch (CustomerException e) {
            throw new CustomerException(HttpStatus.INTERNAL_SERVER_ERROR, "Order completion is failed");
        }
    }

    public void deleteOrder(Long id) {
        try {
            ordersRepository.customDeleteOrder(id);
        } catch (CustomerException e) {
            throw new CustomerException(HttpStatus.INTERNAL_SERVER_ERROR, "Deletion of order is failed");
        }
    }

    public void updateOrder(Long id, OrderRequestDTO orderRequest) {

        Optional<Orders> optional = ordersRepository.findById(id);
        Orders original;
        if (optional.isPresent()) {
            original = optional.get();
        } else {
            throw new CustomerException(HttpStatus.BAD_REQUEST, "ID is not found");
        }

        Orders orderToUpdate = orderMapper.mapToEntity(orderRequest);
        LocalDateTime date = orderToUpdate.getDate();
        Long costumerId = orderToUpdate.getCustomerId();
        Long serviceId = orderToUpdate.getServiceId();

        ordersRepository.customUpdateOrder(id,
                date == null ? original.getDate() : date,
                costumerId == null ? original.getCustomerId() : costumerId,
                serviceId == null ? original.getServiceId() : serviceId);
    }

//    public List<ReservationRequestDTO> getAllReservations(ReservationRequestDTO reservationRequest) {
//        LocalDateTime from = reservationRequest.from();
//        LocalDateTime to = reservationRequest.to();
//        List<ReservationRequestDTO> orders = ordersRepository.findAllReservations(from, to);
//        return orders.stream().map(ReservationMapper::mapToDTO).toList();
//    }
}
