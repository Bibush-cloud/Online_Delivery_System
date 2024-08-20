package org.example.online_delivery_system.controller;

import org.example.online_delivery_system.dto.PaymentDto;
import org.example.online_delivery_system.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentDto> makePayment(@RequestBody PaymentDto paymentDto) {
        return ResponseEntity.ok(paymentService.makePayment(paymentDto));
    }

}
