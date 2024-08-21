package org.example.online_delivery_system.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.online_delivery_system.dto.OrderDto;
import org.example.online_delivery_system.entity.Order;
import org.example.online_delivery_system.entity.User;
import org.example.online_delivery_system.exception.ResourceNotFoundException;
import org.example.online_delivery_system.mappers.OrderMapper;
import org.example.online_delivery_system.repository.OrderRepository;
import org.example.online_delivery_system.repository.UserRepository;
import org.example.online_delivery_system.service.OrderService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        log.info("Inside Create Order");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given username"));
        Order order = OrderMapper.toEntity(orderDto, null, user);
        orderRepository.save(order);

        return OrderMapper.toDto(order);
    }


}
