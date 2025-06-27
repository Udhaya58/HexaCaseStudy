package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem,Long> {

}
