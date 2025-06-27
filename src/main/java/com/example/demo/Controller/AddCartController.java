package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.CartItem;
import com.example.demo.Ser.AddToCartSer;
@RequestMapping("/cartcontr")
@RestController
public class AddCartController {
	@Autowired
	private AddToCartSer addto;
	
	 @PostMapping("/addcart/{userId}/{menuId}/{quantity}")
	    public String addToCart(
	            @PathVariable Long userId,
	            @PathVariable Long menuId,
	            @PathVariable int quantity) {
	        return addto.addToCart(userId, menuId, quantity);
	    }
	 // View cart
	    @GetMapping("/viewcart/{userId}")
	    public List<CartItem> viewCart(@PathVariable Long userId) {
	        return addto.viewCart(userId);
	    }

	    // Update quantity
	    @PutMapping("/updatecart/{userId}/{menuId}/{quantity}")
	    public String updateQuantity(@PathVariable Long userId,
	                                 @PathVariable Long menuId,
	                                 @PathVariable int quantity) {
	        return addto.updateQuantity(userId, menuId, quantity);
	    }

	    // Remove item
	    @DeleteMapping("/removecart/{userId}/{menuId}")
	    public String removeItem(@PathVariable Long userId,
	                             @PathVariable Long menuId) {
	        return addto.removeItem(userId, menuId);
	    }

	    // Calculate total cost
	    @GetMapping("/totalcart/{userId}")
	    public double getTotal(@PathVariable Long userId) {
	        return addto.calculateTotal(userId);
	    }
	

}
