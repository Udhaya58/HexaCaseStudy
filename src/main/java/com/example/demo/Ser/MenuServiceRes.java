package com.example.demo.Ser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Menu;
import com.example.demo.Model.Restaurant;
import com.example.demo.Repo.MenuRepo;
import com.example.demo.Repo.RestaurantRepo;

@Service
public class MenuServiceRes {

    @Autowired private MenuRepo menuRepo;
    @Autowired private RestaurantRepo restaurantRepo;

    public Menu addMenu(Long restaurantId, Menu menu) {
        Restaurant restaurant = restaurantRepo.findById(restaurantId).orElseThrow();
        menu.setRestaurant(restaurant);
        return menuRepo.save(menu);
    }

    public Menu updateMenu(Long id, Menu newMenu) {
        Menu menu = menuRepo.findById(id).orElseThrow();
        menu.setItemName(newMenu.getItemName());
        menu.setDescription(newMenu.getDescription());
        menu.setUrl(newMenu.getUrl());
        menu.setCategory(newMenu.getCategory());
        menu.setType(newMenu.getType());
        menu.setPrice(newMenu.getPrice());
        menu.setAvailabilityTime(newMenu.getAvailabilityTime());
        menu.setTasteInfo(newMenu.getTasteInfo());
        menu.setNutritionalInfo(newMenu.getNutritionalInfo());
        return menuRepo.save(menu);
    }

    public void deleteMenu(Long id) {
        menuRepo.deleteById(id);
    }

    public String markOutOfStock(Long id) {
        Menu menu = menuRepo.findById(id).orElseThrow();
        menu.setAvailable(false);
        menuRepo.save(menu);
        return "Marked as out of stock";
    }

    public List<Menu> getMenusByRestaurant(Long restaurantId) {
        return menuRepo.findByRestaurantId(restaurantId);
    }
}

