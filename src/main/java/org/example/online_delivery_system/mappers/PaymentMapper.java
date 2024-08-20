package org.example.online_delivery_system.mappers;

import org.example.online_delivery_system.dto.PaymentDto;
import org.example.online_delivery_system.entity.Order;
import org.example.online_delivery_system.entity.Payment;

import java.time.LocalDateTime;

public class PaymentMapper {
    public static Payment toEntity(PaymentDto paymentDto, Order order) {
        return Payment.builder()
                .id(paymentDto.getId())
                .amount(paymentDto.getAmount())
                .paymentDate(LocalDateTime.now())
                .order(order)
                .build();
    }

    public static PaymentDto toDto(Payment payment) {
        return PaymentDto.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .paymentDate(payment.getPaymentDate())
                .orderId(payment.getOrder().getId())
                .build();
    }

}
