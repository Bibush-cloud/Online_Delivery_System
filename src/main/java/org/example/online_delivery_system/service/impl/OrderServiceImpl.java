package org.example.online_delivery_system.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.online_delivery_system.dto.OrderDto;
import org.example.online_delivery_system.entity.Order;
import org.example.online_delivery_system.mappers.OrderMapper;
import org.example.online_delivery_system.repository.OrderRepository;
import org.example.online_delivery_system.service.OrderService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        log.info("Inside Create Order");
      Order order =  OrderMapper.toEntity(orderDto, null);
      orderRepository.save(order);

      return OrderMapper.toDto(order);
    }



}
