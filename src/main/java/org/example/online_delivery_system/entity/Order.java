package org.example.online_delivery_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String item;

    private int quantity;

    private LocalDateTime orderDate;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private Payment payment;
}
