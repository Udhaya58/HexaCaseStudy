package com.example.demo.Ser;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.UserNotFound;
import com.example.demo.Model.*;
import com.example.demo.Repo.*;
@Service
public class AddToCartSer {

    @Autowired
    private UserRepo userrepo;
    @Autowired
    private MenuRepo menurepo;
    @Autowired
    private CartRepo cartrepo;
    @Autowired
    private CartItemRepo cartitemrepo;

    public String addToCart(Long userId, Long menuId, int quantity) {
    	 User user = userrepo.findById(userId)
    	            .orElseThrow(()->new UserNotFound("User id not found:"+userId) );
    	    
    	    Menu menu = menurepo.findById(menuId)
    	            .orElseThrow(() -> new RuntimeException("Menu item not found with ID: " + menuId));

        Cart cart = user.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cartrepo.save(cart);
            user.setCart(cart);
            userrepo.save(user);
        }

        
        Optional<CartItem> existingItem = cart.getCartitem().stream()
                .filter(item -> item.getMenu().getId().equals(menuId))
                .findFirst();

        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
            cartitemrepo.save(item);
        } else {
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setMenu(menu);
            newItem.setQuantity(quantity);
            cart.getCartitem().add(newItem);
            cartitemrepo.save(newItem);
        }

        return "Item added to cart successfully.";
    }
 
    public List<CartItem> viewCart(Long userId) {
        User user = userrepo.findById(userId).orElseThrow();
        Cart cart = user.getCart();
        return cart != null ? cart.getCartitem() : List.of();
    }

 
    public String updateQuantity(Long userId, Long menuId, int newQuantity) {
        User user = userrepo.findById(userId).orElseThrow(()->new UserNotFound("User id not found:"+userId) );;
        Cart cart = user.getCart();
        if (cart == null) return "Cart not found";

        for (CartItem item : cart.getCartitem()) {
            if (item.getMenu().getId().equals(menuId)) {
                item.setQuantity(newQuantity);
                cartitemrepo.save(item);
                return "Quantity updated.";
            }
        }

        return "Item not found in cart.";
    }

   
    public String removeItem(Long userId, Long menuId) {
        User user = userrepo.findById(userId).orElseThrow(()->new UserNotFound("User id not found:"+userId) );;
        Cart cart = user.getCart();
        if (cart == null) return "Cart not found";

        cart.getCartitem().removeIf(item -> {
            boolean match = item.getMenu().getId().equals(menuId);
            if (match) cartitemrepo.delete(item);
            return match;
        });

        return "Item removed from cart.";
    }
    public double calculateTotal(Long userId) {
        User user = userrepo.findById(userId).orElseThrow(()->new UserNotFound("User id not found:"+userId) );
        Cart cart = user.getCart();
        if (cart == null) return 0.0;

        return cart.getCartitem().stream()
                .mapToDouble(item -> item.getMenu().getPrice() * item.getQuantity())
                .sum();
    }

}
