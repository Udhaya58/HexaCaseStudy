package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Orders;

public interface OrderRepo extends JpaRepository<Orders,Long>{
	List<Orders> findByRestaurantId(Long restaurantId); 

    List<Orders> findByRestaurantIdAndStatus(Long restaurantId, String status); 
}
