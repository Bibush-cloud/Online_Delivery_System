package org.example.online_delivery_system.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private Integer id;

    private String item;

    private BigDecimal totalAmount;

    private int quantity;

    private LocalDateTime orderDate;

    private Integer userId;
}
