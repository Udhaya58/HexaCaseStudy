package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Menu;
import com.example.demo.Ser.MenuServiceRes;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/restaurant")
@RestController
public class MenuControllerRes {

    @Autowired private MenuServiceRes menuService;

    @PostMapping("/addmenuid/{restaurantId}")
    public Menu addMenu(@PathVariable Long restaurantId, @RequestBody Menu menu) {
        return menuService.addMenu(restaurantId, menu);
    }

    @PutMapping("/updatemenuid/{id}")
    public Menu updateMenu(@PathVariable Long id, @RequestBody Menu menu) {
        return menuService.updateMenu(id, menu);
    }

    @DeleteMapping("/deletemenuid/{id}")
    public String deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return "Menu deleted";
    }

    @PutMapping("/outofstockmenu/{id}")
    public String markOutOfStock(@PathVariable Long id) {
        return menuService.markOutOfStock(id);
    }

    @GetMapping("/listmenuid/{restaurantId}")
    public List<Menu> listMenus(@PathVariable Long restaurantId) {
        return menuService.getMenusByRestaurant(restaurantId);
    }
}

