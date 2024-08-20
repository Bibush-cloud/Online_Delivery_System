package org.example.online_delivery_system.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.online_delivery_system.repository.OrderRepository;
import org.example.online_delivery_system.repository.PaymentRepository;
import org.example.online_delivery_system.service.DashboardService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class DashboardServiceImpl implements DashboardService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    public DashboardServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Map<String, Object> getMetrics() {
        log.info("Inside getMetrics");
        long totalOrders = orderRepository.countOrdersForToday();
        BigDecimal totalPayments = paymentRepository.sumPaymentsForToday();
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("totalOrders", totalOrders);
        metrics.put("totalPayments", totalPayments);

        return metrics;
    }
}
