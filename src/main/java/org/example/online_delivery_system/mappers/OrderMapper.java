package org.example.online_delivery_system.mappers;

import org.example.online_delivery_system.dto.OrderDto;
import org.example.online_delivery_system.entity.Order;
import org.example.online_delivery_system.entity.Payment;

import java.time.LocalDateTime;

public class OrderMapper {
    public static Order toEntity(OrderDto orderDto, Payment payment) {
        return Order.builder()
                .id(orderDto.getId())
                .item(orderDto.getItem())
                .quantity(orderDto.getQuantity())
                .orderDate(LocalDateTime.now())
                .payment(payment)
                .build();
    }

    public static OrderDto toDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .item(order.getItem())
                .quantity(order.getQuantity())
                .orderDate(order.getOrderDate())
                .build();
    }
}
