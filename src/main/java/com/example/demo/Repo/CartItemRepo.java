package com.example.demo.Repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem,Long> {
	
	
}
