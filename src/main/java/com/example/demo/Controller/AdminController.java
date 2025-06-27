package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.*;
import com.example.demo.Repo.RestaurantRepo;
import com.example.demo.Repo.UserRepo;
import com.example.demo.Ser.AdminSer;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminSer adminService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private RestaurantRepo restaurantRepository;


    // ----- User Management -----

  
    @PostMapping("/adduser")
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    @DeleteMapping("/deleteuser/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        adminService.deleteUser(userId);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    // ----- Restaurant Management -----
    @PostMapping("/addrestaurant")
    public Restaurant addRestaurant(Restaurant restaurant) {
        restaurant.setPassword(passwordEncoder.encode(restaurant.getPassword()));
        return restaurantRepository.save(restaurant);
    }

    @DeleteMapping("/deleterestaurant/{restaurantId}")
    public void deleteRestaurant(@PathVariable Long restaurantId) {
        adminService.deleteRestaurant(restaurantId);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants() {
        return adminService.getAllRestaurants();
    }

    // ----- Menu Management -----

    @PostMapping("/addmenu")
    public Menu addMenu(@RequestBody Menu menu) {
        return adminService.addMenu(menu);
    }

    @PutMapping("/updatemenu/{menuId}")
    public Menu updateMenu(@PathVariable Long menuId, @RequestBody Menu updatedMenu) {
        return adminService.updateMenu(menuId, updatedMenu);
    }

    @DeleteMapping("/deletemenu/{menuId}")
    public void deleteMenu(@PathVariable Long menuId) {
        adminService.deleteMenu(menuId);
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return adminService.getAllMenus();
    }

    
}
