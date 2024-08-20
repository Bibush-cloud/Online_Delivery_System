package org.example.online_delivery_system.service;

import org.example.online_delivery_system.dto.PaymentDto;

public interface PaymentService {

    PaymentDto makePayment(PaymentDto payment);
}
