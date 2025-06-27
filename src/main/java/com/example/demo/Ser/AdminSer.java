package com.example.demo.Ser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.*;
import com.example.demo.Repo.*;

@Service
public class AdminSer {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private MenuRepo menuRepo;

    // 1. Manage Users
    public User addUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // 2. Manage Restaurants
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    public void deleteRestaurant(Long restaurantId) {
        restaurantRepo.deleteById(restaurantId);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    // 3. Manage Menu
    public Menu addMenu(Menu menu) {
        return menuRepo.save(menu);
    }

    public Menu updateMenu(Long menuId, Menu newMenu) {
        Menu menu = menuRepo.findById(menuId).orElseThrow();
        menu.setItemName(newMenu.getItemName());
        menu.setDescription(newMenu.getDescription());
        menu.setCategory(newMenu.getCategory());
        menu.setPrice(newMenu.getPrice());
        menu.setAvailabilityTime(newMenu.getAvailabilityTime());
        menu.setType(newMenu.getType());
        menu.setTasteInfo(newMenu.getTasteInfo());
        menu.setNutritionalInfo(newMenu.getNutritionalInfo());
        return menuRepo.save(menu);
    }

    public void deleteMenu(Long menuId) {
        menuRepo.deleteById(menuId);
    }

    public List<Menu> getAllMenus() {
        return menuRepo.findAll();
    }
}
