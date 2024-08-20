package org.example.online_delivery_system.repository;

import org.example.online_delivery_system.entity.Order;
import org.example.online_delivery_system.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    Payment findByOrder(Order order);

    @Query("SELECT SUM(p.amount) FROM Payment p WHERE DATE(p.paymentDate) = CURRENT_DATE")
    BigDecimal sumPaymentsForToday();

}
