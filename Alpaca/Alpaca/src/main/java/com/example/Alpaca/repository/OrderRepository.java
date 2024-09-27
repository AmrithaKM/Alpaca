package com.example.Alpaca.repository;


import com.example.Alpaca.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
