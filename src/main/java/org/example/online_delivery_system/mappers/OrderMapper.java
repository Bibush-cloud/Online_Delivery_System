package org.example.online_delivery_system.mappers;

import org.example.online_delivery_system.dto.OrderDto;
import org.example.online_delivery_system.entity.Order;
import org.example.online_delivery_system.entity.Payment;
import org.example.online_delivery_system.entity.User;

import java.time.LocalDateTime;

public class OrderMapper {
    public static Order toEntity(OrderDto orderDto, Payment payment, User user) {
        return Order.builder()
                .id(orderDto.getId())
                .item(orderDto.getItem())
                .quantity(orderDto.getQuantity())
                .orderDate(LocalDateTime.now())
                .payment(payment)
                .user(user)
                .build();
    }

    public static OrderDto toDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .item(order.getItem())
                .quantity(order.getQuantity())
                .orderDate(order.getOrderDate())
                .userId(order.getUser().getId())
                .build();
    }
}
