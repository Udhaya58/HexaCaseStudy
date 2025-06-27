package com.example.demo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant,Long>{

	Optional<Restaurant> findByEmail(String email);

}
