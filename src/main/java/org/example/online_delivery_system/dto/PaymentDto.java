package org.example.online_delivery_system.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {

    private Integer id;

    private BigDecimal amount;

    private LocalDateTime paymentDate;

    private Integer orderId;
}
