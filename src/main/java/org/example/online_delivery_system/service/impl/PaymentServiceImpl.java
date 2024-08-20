package org.example.online_delivery_system.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.online_delivery_system.dto.PaymentDto;
import org.example.online_delivery_system.entity.Order;
import org.example.online_delivery_system.entity.Payment;
import org.example.online_delivery_system.exception.AlreadyExistException;
import org.example.online_delivery_system.exception.ResourceNotFoundException;
import org.example.online_delivery_system.mappers.PaymentMapper;
import org.example.online_delivery_system.repository.OrderRepository;
import org.example.online_delivery_system.repository.PaymentRepository;
import org.example.online_delivery_system.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public PaymentDto makePayment(PaymentDto paymentDto) {
        log.info(" Inside Making payment");
        Order order = orderRepository.findById(paymentDto.getOrderId())
                .orElseThrow(() -> new ResourceNotFoundException("Order Not found with given Id"));

        Payment existingPayment = paymentRepository.findByOrder(order);
        if (existingPayment != null) {
            throw new AlreadyExistException("Payment already exists for this order.");
        }

        Payment payment = PaymentMapper.toEntity(paymentDto, order);
        paymentRepository.save(payment);

        return PaymentMapper.toDto(payment);
    }
}
