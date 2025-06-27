package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Menu;

public interface MenuRepo extends JpaRepository<Menu,Long> {

	List<Menu> findByCategoryAndType(String category, String type);

	 List<Menu> findByPriceBetween(Double min, Double max);
	 List<Menu> findByType(String type);

	 List<Menu> findByRestaurantId(Long restaurantId);
}
 