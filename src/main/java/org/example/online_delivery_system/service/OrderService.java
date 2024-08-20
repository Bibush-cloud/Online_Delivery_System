package org.example.online_delivery_system.service;

import org.example.online_delivery_system.dto.OrderDto;

public interface OrderService {

    OrderDto createOrder(OrderDto order);
}
