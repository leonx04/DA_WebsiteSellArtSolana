package com.example.app.repository;

import com.example.app.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderItemRepository extends JpaRepository<OrderItem,Long> {
}
